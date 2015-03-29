package org.uva.student.calinwouter.qlqls.qls.helper;

import org.uva.student.calinwouter.qlqls.generated.lexer.Lexer;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.AStylesheetBegin;
import org.uva.student.calinwouter.qlqls.generated.node.Start;
import org.uva.student.calinwouter.qlqls.generated.parser.Parser;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.exceptions.CouldNotFindMatchingQLSComponentException;
import org.uva.student.calinwouter.qlqls.qls.model.functions.StyleSheet;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class QLSHelper {

    public static StyleSheet interpretStylesheetString(String input) throws ParserException, IOException, LexerException, CouldNotFindMatchingQLSComponentException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        QLSInterpreter qlsInterpreter = new QLSInterpreter();
        return qlsInterpreter.interpret((AStylesheetBegin) ast.getPBegin());
    }

}
