package org.fugazi.qls.type_checker;

import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.fugazi.ql.type_checker.issue.ASTNodeIssueType;
import org.fugazi.qls.type_checker.issue.ASTQlsNodeIssueType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCheckerWidgetCompatibility  extends TestQlsTypeCheckerBase {

    @Before
    public void setUp() {
        this.qlsFileName = "incompatibleWidgets.qls";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = qlsChecker.isFormCorrect();
        assertFalse(formCorrect);
    }

    @Test
    public void testErrorCount() throws Exception {
        List<ASTNodeIssue> errors = qlsChecker.getErrors();

        assertFalse(errors.isEmpty());

        for (ASTNodeIssue error: errors) {
            System.out.println(error.getErrorType() + " " + error.getMessage());
        }
        assertEquals(6, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeIssue> errors = qlsChecker.getErrors();

        ASTNodeIssueType expectedType = ASTQlsNodeIssueType.QLS_ERROR.WRONG_WIDGET_TYPE;
        List<ASTNodeIssueType> receivedTypes = new ArrayList<>();

        for (ASTNodeIssue error: errors) {
            receivedTypes.add(error.getErrorType());
        }
        // no custom arrayEquals method
        for (ASTNodeIssueType received : receivedTypes) {
            assertTrue(received.equals(expectedType));
        }
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeIssue> warnings = qlsChecker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
