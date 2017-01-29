package ruke.vrj.compiler;

import java.util.ArrayList;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import ruke.vrj.Symbol;
import ruke.vrj.antlr.vrjLexer;
import ruke.vrj.antlr.vrjParser;
import ruke.vrj.phase.Definition;
import ruke.vrj.phase.Translate;
import ruke.vrj.phase.TypeCheck;

/**
 * Created by Ruke on 23/09/2016.
 */
public class Compiler {

  private ArrayList<Result> results = new ArrayList<>();

  public ArrayList<Result> getResults() {
    return this.results;
  }

  public String compile(ANTLRInputStream input) {
    final Lexer lexer = new vrjLexer(input);
    final TokenStream tokenStream = new CommonTokenStream(lexer);
    final vrjParser parser = new vrjParser(tokenStream);

    final Symbol main = new Symbol();

    final Definition definition = new Definition(main.children);
    final TypeCheck typecheck = new TypeCheck(main.children);

    definition.visit(parser.init());
    parser.reset();

    typecheck.visit(parser.init());

    this.results = new ArrayList<>();

    this.results.addAll(definition.getResults());
    this.results.addAll(typecheck.getResults());

    if (this.results.isEmpty()) {
      parser.reset();

      final Translate translate = new Translate(main.children);

      return translate.visit(parser.init()).toString();
    }

    return "";
  }

  public String compile(String code) {
    return compile(new ANTLRInputStream(code + "\n"));
  }

}
