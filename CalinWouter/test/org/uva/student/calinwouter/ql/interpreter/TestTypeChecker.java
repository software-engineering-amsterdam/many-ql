package org.uva.student.calinwouter.ql.interpreter;

import org.junit.Test;
import org.uva.student.calinwouter.ql.generated.lexer.LexerException;
import org.uva.student.calinwouter.ql.generated.parser.ParserException;
import org.uva.student.calinwouter.ql.interpreter.exceptions.*;
import org.uva.student.calinwouter.ql.interpreter.helper.InterpreterHelper;
import org.uva.student.calinwouter.ql.interpreter.typechecker.FormTypeChecker;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.uva.student.calinwouter.ql.interpreter.helper.QLGeneratorHelper.*;

/**
 * - Reference to undefined questions
 * - Duplicate question declarations (NOT with different types)
 * - Conditions that are not of the type boolean
 * - Operands of invalid type to operators
 * - Duplicate labels (warning)
 */
public class TestTypeChecker {

    // TODO change type check strings to helper functions.

    @Test
    public void testUndefinedQuestions() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("if (a) { a: \"a\" int }"));
        assertTrue(formInterpreter.getFatalException() instanceof VariableNotSetException);
    }

    @Test
    public void testFieldInUse() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("a: \"a\" int a: \"a\" int"));
        assertTrue(formInterpreter.getFatalException() instanceof FieldInUseException);
    }

    @Test
    public void testIfNotBool() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("if (5) {  a: \"a\" int }"));
        assertTrue(formInterpreter.getFatalException() instanceof IfNotBoolOrNull);
    }

    @Test
    public void testOperandsInvalidType() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("a: \"a\" boolean b: \"b\" int c: \"c:\" int(a - b)"));
        assertTrue(formInterpreter.getFatalException() instanceof CastException);
    }

    @Test
    public void testComputedValueType() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("a: \"a\" boolean c: \"c:\" int(a)"));
        assertTrue(formInterpreter.getFatalException() instanceof InvalidComputedValueType);
    }

    @Test
    public void testOperandsInvalidTypeIf() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("a: \"a\" int if (a) { b: \"b\" int } "));
        assertTrue(formInterpreter.getFatalException() instanceof IfNotBoolOrNull);
    }

    @Test
    public void testDuplicateLabels() throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = InterpreterHelper
                .typeCheckString(form("a: \"test\" boolean b: \"test\" boolean"));
        assertTrue(formInterpreter.getWarnings().get(0) instanceof LabelInUseException);
    }

}
