package ruke.vrj.server;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Ruke on 25/09/2016.
 */
@Ignore
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
  public void mustHandleEditOnlyInRange() {
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
                /* -- */"function foo takes nothing returns nothing",
                /* -- only check this range */    "local foo f",
                /* -- */"endfunction",
            "function bar takes nothing returns integer",
            "return true",
            "endfunction"
        ), 2, 2)
    );
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
                .add(Json.object().add("label", "handle"))
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

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "call ",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 2)
                .add("char", 5)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "foo").add("kind", LanguageServer.FUNCTION_TYPE))
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

    requestEdit(ls, "my-uri", String.join("\n",
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
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 11)
                .add("char", 18)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "myRealVar")
                    .add("kind", LanguageServer.VARIABLE_TYPE))
                .add(Json.object().add("label", "myIntegerVar")
                    .add("kind", LanguageServer.VARIABLE_TYPE))
                .add(Json.object().add("label", "foo").add("kind", LanguageServer.FUNCTION_TYPE))
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

    requestEdit(ls, "my-uri", String.join("\n",
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
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 9)
                .add("char", 17)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "s").add("kind", LanguageServer.VARIABLE_TYPE))
        )
    );

    Assert.assertEquals(
        expected.toString(),
        ls.handleRequest(request.toString()).toString()
    );
  }

  @Test
  public void mustSuggestByName() {
    LanguageServer ls = new LanguageServer();

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "endfunction",
        "function bar takes nothing returns nothing",
        "endfunction",
        "function baz takes nothing returns nothing",
        "call b",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 6)
                .add("char", 6)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "bar").add("kind", LanguageServer.FUNCTION_TYPE))
                .add(Json.object().add("label", "baz").add("kind", LanguageServer.FUNCTION_TYPE))
        )
    );

    Assert.assertEquals(
        expected.toString(),
        ls.handleRequest(request.toString()).toString()
    );
  }

  @Test
  public void mustIncludeAndSuggestNatives() {
    LanguageServer ls = new LanguageServer();

    ls.loadNatives();

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "call Ch",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 2)
                .add("char", 7)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "Cheat").add("kind", LanguageServer.FUNCTION_TYPE))
                .add(Json.object().add("label", "ChangeLevel")
                    .add("kind", LanguageServer.FUNCTION_TYPE))
                .add(Json.object().add("label", "ChooseRandomItem")
                    .add("kind", LanguageServer.FUNCTION_TYPE))
        )
    );

    Assert.assertEquals(
        expected.toString(),
        ls.handleRequest(request.toString()).toString()
    );
  }

  @Test
  public void mustSuggestCompatibleNativeType() {
    LanguageServer ls = new LanguageServer();

    ls.loadNatives();

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "call CreateUnit(GetLocalP",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 2)
                .add("char", 25)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "GetLocalPlayer")
                    .add("kind", LanguageServer.FUNCTION_TYPE))
        )
    );

    Assert.assertEquals(
        expected.toString(),
        ls.handleRequest(request.toString()).toString()
    );
  }

  @Test
  public void mustSuggestCompatibleNativeTypeInMiddleOfExpression() {
    LanguageServer ls = new LanguageServer();

    ls.loadNatives();

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "call RemoveItem(CreateItem(1234, ",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 2)
                .add("char", 33)
                .add("uri", "my-uri")
        );

    Assert.assertNotEquals(
        0,
        ls.handleSuggest(
            request.get("data").asObject()
        ).get("suggestions").asArray().size()
    );
  }

  @Test
  public void mustSuggestRespectingCursor() {
    LanguageServer ls = new LanguageServer();

    ls.loadNatives();

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "call CreateUnit(GetLocalPlayer(), AbilityId(), gethandle",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 2)
                .add("char", 56)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions",
            Json.array().asArray()
                .add(Json.object().add("label", "GetHandleId")
                    .add("kind", LanguageServer.FUNCTION_TYPE))
        )
    );

    Assert.assertEquals(
        expected.toString(),
        ls.handleRequest(request.toString()).toString()
    );
  }

  @Test
  public void mustNotSuggestMoreThanLastArgument() {
    LanguageServer ls = new LanguageServer();

    ls.loadNatives();

    requestEdit(ls, "my-uri", String.join("\n",
        "function foo takes nothing returns nothing",
        "call CreateItem(1, 1, 1, ",
        "endfunction"
    ));

    JsonObject request = Json.object();

    request
        .add("type", "suggest")
        .add("data",
            Json.object()
                .add("line", 2)
                .add("char", 25)
                .add("uri", "my-uri")
        );

    JsonObject expected = Json.object();

    expected.add("suggest",
        Json.object().add("suggestions", Json.array().asArray())
    );

    Assert.assertEquals(
        expected.toString(),
        ls.handleRequest(request.toString()).toString()
    );
  }

}