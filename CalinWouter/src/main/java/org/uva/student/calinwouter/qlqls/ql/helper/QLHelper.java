package org.uva.student.calinwouter.qlqls.ql.helper;

import org.uva.student.calinwouter.qlqls.generated.lexer.Lexer;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.generated.parser.Parser;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.QLInterpreter;
import org.uva.student.calinwouter.qlqls.ql.QLStaticAnalyser;
import org.uva.student.calinwouter.qlqls.ql.QLTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class QLHelper {

    public static TypeCheckResults typeCheckString(String input) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        QLTypeChecker qlTypeChecker = new QLTypeChecker(form);
        return qlTypeChecker.typeCheck();
    }

    public static QLInterpreter interpretQlString(String input) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        QLInterpreter qlInterpreter = new QLInterpreter((AForm) ((AFormBegin) ast.getPBegin()).getForm());
        qlInterpreter.interpret(new VariableTable());
        return qlInterpreter;
    }

    public static StaticFields analyzeQlString(String input) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        QLStaticAnalyser staticAnalyser = new QLStaticAnalyser((AForm) ((AFormBegin) ast.getPBegin()).getForm());
        return staticAnalyser.collectStaticFields();
    }

    private QLHelper() {
    }

}
