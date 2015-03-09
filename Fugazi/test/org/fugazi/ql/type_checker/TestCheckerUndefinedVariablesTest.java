package org.fugazi.ql.type_checker;

import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestCheckerUndefinedVariablesTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "undefinedVariableForm.ql";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = checker.isFormCorrect();
        assertFalse(formCorrect);
    }

    @Test
    public void testErrorCount() throws Exception {
        List<ASTNodeIssue> errors = checker.getErrors();

        assertFalse(errors.isEmpty());
        // will report also undefined question
        assertEquals(2, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeIssue> errors = checker.getErrors();

        List<ASTNodeIssueType> expectedTypes = new ArrayList<>();
        List<ASTNodeIssueType> receivedTypes = new ArrayList<>();
        expectedTypes.add(ASTNodeIssueType.ERROR.UNDEFINED);
        expectedTypes.add(ASTNodeIssueType.ERROR.TYPE_MISMATCH);

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
        List<ASTNodeIssue> warnings = checker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
