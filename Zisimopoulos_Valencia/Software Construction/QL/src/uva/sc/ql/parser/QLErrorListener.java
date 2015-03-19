package uva.sc.ql.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import uva.sc.core.errors.IError;
import uva.sc.core.errors.Syntax;
import uva.sc.ql.parser.exceptions.InlineRecognitionException;

public class QLErrorListener extends BaseErrorListener {
    private final List<IError> errors = new ArrayList<IError>();

    public List<IError> getErrors() {
	return errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
	    Object offendingSymbol, int line, int charPositionInLine,
	    String msg, RecognitionException e) {
	msg = "Line " + line + " " + msg;
	if (e == null) {
	    // e is null when the parser was able to recover in line without
	    // exiting the surrounding rule.
	    e = new InlineRecognitionException(msg, recognizer,
		    ((Parser) recognizer).getInputStream(),
		    ((Parser) recognizer).getContext(), (Token) offendingSymbol);
	}
	this.errors.add(new Syntax(msg, e));
    }
}
