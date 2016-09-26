package ruke.vrj.server;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruke on 25/09/2016.
 */
public class LanguageServerTest {
    
    private String requestEdit(LanguageServer ls, String uri, String code, int line, int range) {
        return ls.handleRequest(
            Json.object()
                .add("type", "edit")
                .add("data",
                    Json.object()
                        .add("uri", uri)
                        .add("content", code)
                        .add("line", line)
                        .add("range", range)
                ).toString()
        ).toString();
    }
    
    private String requestEdit(LanguageServer ls, String uri, String code) {
        return requestEdit(ls, uri, code, -1, -1);
    }
    
    @Test
    public void mustHandleEdit() {
        LanguageServer ls = new LanguageServer();
        
        JsonObject expected = Json.object();
        
        expected.add("edit",
            Json.object()
                .add("uri", "some-uri")
                .add("errors",
                    Json.array().asArray()
                        .add(
                            Json.object()
                                .add("message", "2:6 - foo is not a valid type")
                                .add("range",
                                    Json.object()
                                        .add("start",
                                            Json.object()
                                                .add("line", 1)
                                                .add("character", 6)
                                        )
                                        .add("end",
                                            Json.object()
                                                .add("line", 1)
                                                .add("character", 6)
                                        )
                                )
                        )
                )
        );
    
        Assert.assertEquals(
            expected.toString(),
            requestEdit(ls, "some-uri", String.join("\n",
                "function foo takes nothing returns nothing",
                    "local foo f",
                "endfunction"
            ))
        );
    }
    
    @Test
    public void mustSuggestTypes() {
        LanguageServer ls = new LanguageServer();
        
        requestEdit(ls, "my-uri", String.join("\n",
            "function foo takes nothing returns nothing",
                "local ",
            "endfunction"
        ));
        
        JsonObject request = Json.object();
        
        request
            .add("type", "suggest")
            .add("data",
                Json.object()
                    .add("uri", "my-uri")
                    .add("line", 2)
                    .add("char", 6)
            );
        
        JsonObject expected = Json.object();
        
        expected.add("suggest",
            Json.object().add("suggestions",
                Json.array().asArray()
                    .add(Json.object().add("label", "boolean"))
                    .add(Json.object().add("label", "code"))
                    .add(Json.object().add("label", "string"))
                    .add(Json.object().add("label", "null"))
                    .add(Json.object().add("label", "nothing"))
                    .add(Json.object().add("label", "integer"))
                    .add(Json.object().add("label", "real"))
            )
        );
        
        Assert.assertEquals(
            expected.toString(),
            ls.handleRequest(request.toString()).toString()
        );
    }
    
    @Test
    public void mustSuggestFunctions() {
        LanguageServer ls = new LanguageServer();
    
        JsonObject request = Json.object();
    
        request
            .add("type", "suggest")
            .add("data",
                Json.object()
                    .add("line", 2)
                    .add("char", 5)
                    .add("content", String.join("\n",
                        "function foo takes nothing returns nothing",
                            "call ",
                        "endfunction"
                    ))
            );
    
        JsonObject expected = Json.object();
    
        expected.add("suggest",
            Json.object().add("suggestions",
                Json.array().asArray()
                    .add(Json.object().add("label", "foo"))
            )
        );
    
        Assert.assertEquals(
            expected.toString(),
            ls.handleRequest(request.toString()).toString()
        );
    }
    
    @Test
    public void mustSuggestCompatibleType() {
        LanguageServer ls = new LanguageServer();
    
        JsonObject request = Json.object();
    
        request
            .add("type", "suggest")
            .add("data",
                Json.object()
                    .add("line", 11)
                    .add("char", 18)
                    .add("content", String.join("\n",
                        "function foo takes nothing returns integer",
                            "return 42",
                        "endfunction",
                        "function bar takes nothing returns boolean",
                            "return true",
                        "endfunction",
                        "function baz takes nothing returns nothing",
                            "local integer myIntegerVar = 44",
                            "local real myRealVar = 44.2",
                            "local boolean myBoolVar = false",
                            "local integer i = ",
                        "endfunction"
                    ))
            );
    
        JsonObject expected = Json.object();
    
        expected.add("suggest",
            Json.object().add("suggestions",
                Json.array().asArray()
                    .add(Json.object().add("label", "myRealVar"))
                    .add(Json.object().add("label", "myIntegerVar"))
                    .add(Json.object().add("label", "foo"))
            )
        );
    
        Assert.assertEquals(
            expected.toString(),
            ls.handleRequest(request.toString()).toString()
        );
    }
    
    @Test
    public void mustSuggestCompatibleArguments() {
        LanguageServer ls = new LanguageServer();
    
        JsonObject request = Json.object();
    
        request
            .add("type", "suggest")
            .add("data",
                Json.object()
                    .add("line", 9)
                    .add("char", 17)
                    .add("content", String.join("\n",
                        "function foo takes integer a, string b returns boolean",
                            "return true",
                        "endfunction",
                        "function bar takes string whichString, boolean whichBoolean returns integer",
                            "return 42",
                        "endfunction",
                        "function baz takes nothing returns nothing",
                            "local string s",
                            "call bar(s,foo(2,))",
                        "endfunction"
                    ))
            );
    
        JsonObject expected = Json.object();
    
        expected.add("suggest",
            Json.object().add("suggestions",
                Json.array().asArray()
                    .add(Json.object().add("label", "s"))
            )
        );
    
        Assert.assertEquals(
            expected.toString(),
            ls.handleRequest(request.toString()).toString()
        );
    }
    
}