package org.uva.student.calinwouter.qlqls.ql.tests;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.helper.QLHelper;
import org.uva.student.calinwouter.qlqls.ql.model.QLTypeCheckResults;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.uva.student.calinwouter.qlqls.ql.helper.QLGeneratorHelper.form;

/**
 * This type checker checks for:
 *
 * - reference to undefined questions
 * - duplicate question declarations with different types
 * - conditions that are not of the type boolean
 * - operands of invalid type to operators
 * - cyclic dependencies between questions
 * - duplicate labels (warning)
 */
public class TestTypeChecker {

    @Test
    public void testUndefinedReference() throws ParserException, IOException, LexerException {
        QLTypeCheckResults QLTypeCheckResults = QLHelper
                .typeCheckString(form("if (a) { b: \"a\" int }"));
        assertTrue(QLTypeCheckResults.getErrors().contains("Undefined reference: a."));
    }

    @Test
    public void testDuplicateQuestionDifferentTypes() throws ParserException,IOException, LexerException {
        QLTypeCheckResults QLTypeCheckResults = QLHelper
                .typeCheckString(form("a: \"Question 1\" int\n" +
                        "a: \"Question 1\" boolean"));
        assertTrue(QLTypeCheckResults.getErrors().contains("Two questions with the same identifier and a different type were found for variable: a."));
    }

    @Test
    public void testIfConditionNotBool() throws ParserException, IOException, LexerException {
        QLTypeCheckResults QLTypeCheckResults = QLHelper
                .typeCheckString(form("a: \"a\" int if (a) { b: \"b\" int } "));
        assertTrue(QLTypeCheckResults.getErrors().contains("Type is not of type: Boolean."));
    }

    @Test
    public void testOperandsInvalidType() throws ParserException, IOException, LexerException {
        QLTypeCheckResults QLTypeCheckResults = QLHelper
                .typeCheckString(form("a: \"a\" boolean b: \"b\" int c: \"c:\" int(a - b)"));
        assertTrue(QLTypeCheckResults.getErrors().contains("Type is not of type: Integer."));
    }

    @Test
    public void testCyclicDependencies() throws ParserException, IOException, LexerException {
        QLTypeCheckResults QLTypeCheckResults = QLHelper
                .typeCheckString(form("a: \"a\" int(b) b: \"b\" int(a)"));
        assertTrue(QLTypeCheckResults.getErrors().contains("Cyclic dependency between: b and a."));
    }

    @Test
    public void testDuplicateLabels() throws ParserException, IOException, LexerException {
        QLTypeCheckResults QLTypeCheckResults = QLHelper
                .typeCheckString(form("a: \"test\" boolean b: \"test\" boolean"));
        assertTrue(QLTypeCheckResults.getWarnings().contains("Label test found twice."));
    }

}
