package nl.uva.bromance.QL.gui;

import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.exceptions.SyntaxError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class GrammarErrorListener extends BaseErrorListener {

    List<QLError> errorList = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorList.add(new SyntaxError(String.format("%s SyntaxError @ line: %s:%s %s", offendingSymbol, line, charPositionInLine, msg)));
    }


    public void appendSyntaxErrors(List<QLError> errors)
    {
        errors.addAll(errorList);
    }
}