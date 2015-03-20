package uva.sc.ql.parser.exceptions;

import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import uva.sc.core.errors.IError;

@SuppressWarnings("serial")
public class InlineRecognitionException extends RecognitionException implements
	IError {

    public InlineRecognitionException(String message,
	    Recognizer<?, ?> recognizer, IntStream input,
	    ParserRuleContext ctx, Token offendingToken) {
	super(message, recognizer, input, ctx);
	this.setOffendingToken(offendingToken);
    }
}
