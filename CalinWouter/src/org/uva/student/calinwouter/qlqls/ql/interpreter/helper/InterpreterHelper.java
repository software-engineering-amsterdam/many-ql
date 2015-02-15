package org.uva.student.calinwouter.qlqls.ql.interpreter.helper;

import org.uva.student.calinwouter.qlqls.generated.lexer.Lexer;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.generated.parser.Parser;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.gui.GuiFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

// TODO make Spring service...
public class InterpreterHelper {

    private static void interpretStringUsing(String input, FormInterpreter formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }

    public static FormTypeChecker typeCheckString(String input) throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = new FormTypeChecker();
        interpretStringUsing(input, formInterpreter);
        return formInterpreter;
    }

    public static GuiFormInterpreter interpetString(String input) throws ParserException, IOException, LexerException {
        GuiFormInterpreter formInterpreter = new GuiFormInterpreter();
        interpretStringUsing(input, formInterpreter);
        return formInterpreter;
    }

    public static QLSInterpreter interpetStylesheetString(String input) throws ParserException, IOException, LexerException {
        QLSInterpreter qlsInterpreter = new QLSInterpreter();
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        PIdentList stylesheet = ((AStylesheetBegin) ast.getPBegin()).getIdentList();
        stylesheet.apply(qlsInterpreter);
        return qlsInterpreter;
    }

    public static HeadlessFormInterpreter interpetStringHeadless(String input) throws ParserException, IOException, LexerException {
        HeadlessFormInterpreter formInterpreter = new HeadlessFormInterpreter();
        interpretStringUsing(input, formInterpreter);
        return formInterpreter;
    }

}
