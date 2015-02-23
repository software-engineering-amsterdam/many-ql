package nl.uva.bromance.listeners;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Created by Robert on 23-2-2015.
 */
public class GrammarErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        throw new SyntaxError("Syntax error @ line:"+line+":"+charPositionInLine+", symbol: \""+offendingSymbol+ "\"; Expecting:"+e.getExpectedTokens());
    }

    public static class SyntaxError extends Error
    {
        public SyntaxError(String message)
        {super(message);}

    }
}
