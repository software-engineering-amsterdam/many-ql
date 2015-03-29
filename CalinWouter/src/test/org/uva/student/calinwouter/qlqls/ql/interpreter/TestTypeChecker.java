package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.model.TestClass;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.helper.InterpreterHelper;
import org.uva.student.calinwouter.qlqls.ql.QLTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.uva.student.calinwouter.qlqls.helper.QLGeneratorHelper.form;

/**
 * reference to undefined questions
 * duplicate question declarations with different types
 * conditions that are not of the type boolean
 * operands of invalid type to operators
 * cyclic dependencies between questions
 * duplicate labels (warning)
 */
public class TestTypeChecker {

    @Test
    public void testUndefinedReference() throws ParserException, IOException, LexerException {
        TypeCheckResults typeCheckResults = InterpreterHelper
                .typeCheckString(form("if (a) { a: \"a\" int }"));
        assertTrue(typeCheckResults.getErrors().contains("Undefined reference: a."));
    }

    @Test
    public void testDuplicateQuestionDifferentTypes() throws ParserException,IOException, LexerException {
        TypeCheckResults typeCheckResults = InterpreterHelper
                .typeCheckString(form("a: \"Question 1\" int\n" +
                        "a: \"Question 1\" boolean"));
        assertTrue(typeCheckResults.getErrors().contains("Two questions with the same identifier and a different type were found for variable: a."));
    }

    @Test
    public void testIfConditionNotBool() throws ParserException, IOException, LexerException {
        TypeCheckResults typeCheckResults = InterpreterHelper
                .typeCheckString(form("a: \"a\" int if (a) { b: \"b\" int } "));
        assertTrue(typeCheckResults.getErrors().contains("Type is not of type: boolean."));
    }

    @Test
    public void testOperandsInvalidType() throws ParserException, IOException, LexerException {
        TypeCheckResults typeCheckResults = InterpreterHelper
                .typeCheckString(form("a: \"a\" boolean b: \"b\" int c: \"c:\" int(a - b)"));
        assertTrue(typeCheckResults.getErrors().contains("Type is not of type: int."));
    }

    @Test
    public void testCyclicDependencies() throws ParserException, IOException, LexerException {
        TypeCheckResults typeCheckResults = InterpreterHelper
                .typeCheckString(form("a: \"a\" int(b) b: \"b\" int(a)"));
        assertTrue(typeCheckResults.getErrors().contains("Cyclic dependency between b and a."));
    }

    @Test
    public void testDuplicateLabels() throws ParserException, IOException, LexerException {
        TypeCheckResults typeCheckResults = InterpreterHelper
                .typeCheckString(form("a: \"test\" boolean b: \"test\" boolean"));
        assertTrue(typeCheckResults.getWarnings().contains("Label test found twice."));
    }

}
