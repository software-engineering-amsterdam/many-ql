package org.uva.student.calinwouter.qlqls.ql.helper;

import org.uva.student.calinwouter.qlqls.generated.lexer.Lexer;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.generated.parser.Parser;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.QLSTypeChecker;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class InterpreterHelper {

    /*private static void applyInterpreterUsing(String input, FormInterpreter formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }*/
    //TODO this two methods must be merged - the only difference is in the type of parameters they get
    private static void applyInterpreterUsing(String input, HeadlessFormInterpreter formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }

    private static void applyInterpreterUsing(String input, FormTypeChecker formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }

    public static FormTypeChecker typeCheckString(String input) throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = new FormTypeChecker();
        applyInterpreterUsing(input, formInterpreter);
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

    // TODO Code duplication from previous method.
    public static QLSInterpreter typeCheckStylesheetString(String input) throws ParserException, IOException, LexerException {
        QLSTypeChecker qlsInterpreter = new QLSTypeChecker();
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        PIdentList stylesheet = ((AStylesheetBegin) ast.getPBegin()).getIdentList();
        stylesheet.apply(qlsInterpreter);
        return qlsInterpreter;
    }

    public static HeadlessFormInterpreter initializeHeadlessInterpreter(String input) throws ParserException, IOException, LexerException {
        HeadlessFormInterpreter formInterpreter = new HeadlessFormInterpreter();
        applyInterpreterUsing(input, formInterpreter);
        return formInterpreter;
    }

    public static HeadlessFormInterpreter interpetStringHeadless(String input) throws ParserException, IOException, LexerException {
        HeadlessFormInterpreter headlessFormInterpreter = initializeHeadlessInterpreter(input);
        headlessFormInterpreter.interpret();
        return headlessFormInterpreter;
    }

    private InterpreterHelper() {
    }

}
