package nl.uva.bromance.QL.gui;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class GrammarErrorListener extends BaseErrorListener {

    List<SyntaxError> errorList = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorList.add(new SyntaxError(String.format("%s SyntaxError @ line: %s:%s %s", offendingSymbol, line, charPositionInLine, msg)));
    }



    public static class SyntaxError extends Error {
        public SyntaxError(String message) {
            super(message);
        }

    }

    public void appendSyntaxErrors(List<SyntaxError> errors)
    {
        errors.addAll(errorList);
    }
}