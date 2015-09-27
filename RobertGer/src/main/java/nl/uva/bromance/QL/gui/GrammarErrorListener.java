package nl.uva.bromance.QL.gui;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

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