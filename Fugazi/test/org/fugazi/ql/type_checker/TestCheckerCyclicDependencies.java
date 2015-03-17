package org.fugazi.ql.type_checker;

import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCheckerCyclicDependencies extends TestQlTypeCheckerBase {

    @Before
    public void setUp() {
        this.fileName = "cyclicDependencies.ql";
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
        assertEquals(2, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeIssue> errors = qlChecker.getErrors();

        for (ASTNodeIssue error: errors) {
            assertTrue(error.getErrorType().equals(ASTNodeIssueType.ERROR.CYCLIC));
        }
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeIssue> warnings = qlChecker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
