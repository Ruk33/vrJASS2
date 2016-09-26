package ruke.vrj.exception;

import org.antlr.v4.runtime.Token;

/**
 * Created by Ruke on 23/09/2016.
 */
public class CompileException extends RuntimeException {
    
    private Token token;
    private String message;
    
    public CompileException(Token token, String message) {
        this.token = token;
        this.message = message;
    }
    
    public Token getStart() {
        return token;
    }
    
    public Token getEnd() {
        return token;
    }
    
    @Override
    public String getMessage() {
        return String.format(
            "%d:%d - %s",
            token.getLine(),
            token.getCharPositionInLine(),
            message
        );
    }
    
}
