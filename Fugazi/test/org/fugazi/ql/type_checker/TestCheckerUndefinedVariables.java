package org.fugazi.ql.type_checker;

import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.ql.type_checker.issue.error.TypeMismatchError;
import org.fugazi.ql.type_checker.issue.error.UndefinedQuestionError;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestCheckerUndefinedVariables extends TestQlTypeCheckerBase {

    @Before
    public void setUp() {
        this.fileName = "undefinedVariableForm.ql";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = qlChecker.isFormCorrect();
        assertFalse(formCorrect);
    }

    @Test
    public void testErrorCount() throws Exception {
        List<ASTNodeIssue> errors = qlChecker.getErrors();

        assertFalse(errors.isEmpty());
        // will report also undefined question
        assertEquals(2, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeIssue> errors = qlChecker.getErrors();

        List<ASTNodeIssueType> expectedTypes = new ArrayList<>();
        List<ASTNodeIssueType> receivedTypes = new ArrayList<>();
        expectedTypes.add(new UndefinedQuestionError());
        expectedTypes.add(new TypeMismatchError());

        for (ASTNodeIssue error: errors) {
            receivedTypes.add(error.getErrorType());
        }
        // no custom arrayEquals method
        assertEquals(expectedTypes.size(), receivedTypes.size());
        for (ASTNodeIssueType expected : expectedTypes) {
            assertTrue(receivedTypes.contains(expected));
        }
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeIssue> warnings = qlChecker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
