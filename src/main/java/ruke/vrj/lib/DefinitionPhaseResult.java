package ruke.vrj.lib;

import ruke.vrj.antlr.vrjParser;
import ruke.vrj.exception.CompileException;
import ruke.vrj.symbol.Symbol;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ruke on 26/09/2016.
 */
public class DefinitionPhaseResult {
    
    private vrjParser parser;
    private Symbol scope;
    private TokenSymbolMap symbols;
    private ArrayList<CompileException> errors;
    
    public DefinitionPhaseResult(vrjParser parser, Symbol scope, TokenSymbolMap symbols, Collection<CompileException> errors) {
        this.parser = parser;
        this.scope = scope;
        this.symbols = symbols;
        this.errors = new ArrayList<>(errors);
    }
    
    public ArrayList<CompileException> getErrors() {
        return errors;
    }
    
    public vrjParser getParser() {
        return parser;
    }
    
    public Symbol getScope() {
        return scope;
    }
    
    public TokenSymbolMap getSymbols() {
        return symbols;
    }
    
}
