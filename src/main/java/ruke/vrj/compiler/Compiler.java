package ruke.vrj.compiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import ruke.vrj.antlr.vrjLexer;
import ruke.vrj.exception.CompileException;
import ruke.vrj.phase.DefinitionPhase;
import ruke.vrj.phase.ReferencePhase;
import ruke.vrj.phase.TranslatorPhase;
import ruke.vrj.phase.TypePhase;
import ruke.vrj.symbol.Symbol;

import ruke.vrj.antlr.vrjParser;
import ruke.vrj.lib.TokenSymbolMap;

import java.util.ArrayList;

/**
 * Created by Ruke on 23/09/2016.
 */
public class Compiler {
    
    private Symbol scope;
    private TokenSymbolMap symbols;
    private DefinitionPhase definitionPhase;
    private ReferencePhase referencePhase;
    
    public Symbol getScope() {
        return scope;
    }
    
    public TokenSymbolMap getSymbolsMap() {
        return symbols;
    }
    
    public ArrayList<CompileException> getAllErrors() {
        ArrayList<CompileException> errors = new ArrayList<>();
        
        errors.addAll(getDefinitionErrors());
        errors.addAll(getReferenceErrors());
        
        return errors;
    }
    
    public ArrayList<CompileException> getDefinitionErrors() {
        return new ArrayList<>(this.definitionPhase.getErrors());
    }
    
    public ArrayList<CompileException> getReferenceErrors() {
        return new ArrayList<>(this.referencePhase.getErrors());
    }
    
    public String compile(ANTLRInputStream input) {
        try {
            Lexer lexer = new vrjLexer(input);
            TokenStream token = new CommonTokenStream(lexer);
            vrjParser parser = new vrjParser(token);
    
            scope = new Symbol("vrj");
            symbols = new TokenSymbolMap();
            
            definitionPhase = new DefinitionPhase(scope);
            TypePhase typePhase = new TypePhase(scope);
            referencePhase = new ReferencePhase(scope);
            
            definitionPhase.setTokenSymbolMap(symbols);
            referencePhase.setTokenSymbolMap(symbols);
            
            definitionPhase.visit(parser.init());
            parser.reset();
    
            typePhase.visit(parser.init());
            parser.reset();
    
            referencePhase.visit(parser.init());
            parser.reset();
    
            TranslatorPhase translatePhase = new TranslatorPhase(symbols);
            
            return translatePhase.visit(parser.init()).translate().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
