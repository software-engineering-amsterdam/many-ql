package nl.uva.bromance.listeners;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class GrammarErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        throw new SyntaxError(String.format("%s SyntaxError @ line: %s:%s %s", offendingSymbol, line, charPositionInLine, msg));
    }

    public static class SyntaxError extends Error {
        public SyntaxError(String message) {
            super(message);
        }

    }
}
