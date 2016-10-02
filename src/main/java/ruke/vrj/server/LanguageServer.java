package ruke.vrj.server;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import org.antlr.v4.runtime.ANTLRInputStream;
import ruke.vrj.compiler.Compiler;
import ruke.vrj.exception.CompileException;
import ruke.vrj.lib.DefinitionPhaseResult;
import ruke.vrj.symbol.Modifier;
import ruke.vrj.symbol.Symbol;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ruke on 25/09/2016.
 */
public class LanguageServer {
    
    private Compiler compiler = new Compiler();
    private HashMap<String, DefinitionPhaseResult> definitions = new HashMap<>();
    
    public final static int FUNCTION_TYPE = 3;
    public final static int VARIABLE_TYPE = 6;
    
    private JsonObject handleEdit(JsonObject data) {
        JsonObject result = Json.object();
        JsonArray errors = Json.array().asArray();
        
        String uri = data.getString("uri", "");
        String code = data.getString("content", "") + "\n";
        
        Symbol natives = null;
        
        if (definitions.containsKey("common.j")) {
            natives = definitions.get("common.j").getScope();
        }
        
        DefinitionPhaseResult definition = compiler.runDefinitionPhase(
            new ANTLRInputStream(code),
            natives
        );
        
        definitions.put(uri, definition);
        
        ArrayList<CompileException> compilerErrors = compiler.runReferencePhase(
            definition,
            data.getInt("line", -1),
            data.getInt("range", -1)
        );
        
        compilerErrors.addAll(definition.getErrors());
        
        for (CompileException ce : compilerErrors) {
            errors.add(
                Json.object()
                    .add("message", ce.getMessage())
                    .add("range",
                        Json.object()
                            .add("start",
                                Json.object()
                                    .add("line", ce.getStart().getLine() - 1)
                                    .add("character", ce.getStart().getCharPositionInLine())
                            )
                            .add("end",
                                Json.object()
                                    .add("line", ce.getEnd().getLine() - 1)
                                    .add("character", ce.getEnd().getCharPositionInLine())
                            )
                    )
            );
        }
        
        result.add("uri", uri);
        result.add("errors", errors);
        
        return result;
    }
    
    public JsonObject handleSuggest(JsonObject data) {
        JsonObject result = Json.object();
        JsonArray suggestions = Json.array().asArray();
    
        result.add("suggestions", suggestions);
        
        DefinitionPhaseResult definition = definitions.get(data.getString("uri", ""));
        
        if (definition == null) {
            return result;
        }
        
        ArrayList<Symbol> symbols = compiler.runSuggestPhase(
            definition,
            data.getInt("line", -1),
            data.getInt("char", -1)
        );
        
        JsonObject suggestionJson;
        
        for (Symbol suggestion : symbols) {
            suggestionJson = Json.object().add("label", suggestion.getName());
    
            if (suggestion.hasModifier(Modifier.FUNCTION)) {
                suggestionJson.add("kind", FUNCTION_TYPE);
            } else if (suggestion.hasModifier(Modifier.VARIABLE)) {
                suggestionJson.add("kind", VARIABLE_TYPE);
            }
            
            suggestions.add(suggestionJson);
        }
        
        return result;
    }
    
    public JsonObject handleRequest(String input) {
        JsonObject result = Json.object();
        
        try {
            JsonObject request = Json.parse(input).asObject();
            JsonObject data = request.get("data").asObject();
    
            switch (request.getString("type", null)) {
                case "edit":
                    result.add("edit", handleEdit(data));
                    break;
                
                case "suggest":
                    result.add("suggest", handleSuggest(data));
                    break;
            }
        } catch (Exception e) {
            result.add("error", e.toString());
        }
        
        return result;
    }
    
    public void loadNatives() {
        try {
            ANTLRInputStream common = new ANTLRInputStream(
                System.class.getResourceAsStream("/common.j")
            );
            
            definitions.put(
                "common.j",
                compiler.runDefinitionPhase(common)
            );
        } catch (Exception e) {
            System.out.println("Could not load common.j");
            e.printStackTrace();
        }
    }
    
    public void listen(InputStream stream) {
        String line = "";
        
        loadNatives();
    
        Scanner scanner = new Scanner(stream);
        PrintStream out = System.out;
        
        out.println("Listening");
    
        while (true) {
            line = scanner.nextLine();
        
            if (line.isEmpty()) {
                continue;
            }
        
            if ("exit".equals(line)) {
                break;
            }
        
            try {
                out.println(handleRequest(line).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        scanner.close();
    }
    
}
