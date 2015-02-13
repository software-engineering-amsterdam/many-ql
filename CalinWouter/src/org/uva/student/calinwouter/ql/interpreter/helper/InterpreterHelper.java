package org.uva.student.calinwouter.ql.interpreter.helper;

import org.uva.student.calinwouter.ql.generated.lexer.Lexer;
import org.uva.student.calinwouter.ql.generated.lexer.LexerException;
import org.uva.student.calinwouter.ql.generated.node.AForm;
import org.uva.student.calinwouter.ql.generated.node.AFormBegin;
import org.uva.student.calinwouter.ql.generated.node.Start;
import org.uva.student.calinwouter.ql.generated.parser.Parser;
import org.uva.student.calinwouter.ql.generated.parser.ParserException;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.gui.GuiFormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.typechecker.FormTypeChecker;

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

    public static HeadlessFormInterpreter interpetStringHeadless(String input) throws ParserException, IOException, LexerException {
        HeadlessFormInterpreter formInterpreter = new HeadlessFormInterpreter();
        interpretStringUsing(input, formInterpreter);
        return formInterpreter;
    }

}
