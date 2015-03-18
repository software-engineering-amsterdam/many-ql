package uva.sc.core.errors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;

import uva.sc.ql.parser.exceptions.InlineRecognitionException;

public class Syntax extends InlineRecognitionException {

    public Syntax(String message, RecognitionException e) {
	super(message, e.getRecognizer(), e.getInputStream(),
		(ParserRuleContext) e.getCtx(), e.getOffendingToken());
	this.initCause(e);
    }

    public String toString() {
	return getMessage();
    }

}
