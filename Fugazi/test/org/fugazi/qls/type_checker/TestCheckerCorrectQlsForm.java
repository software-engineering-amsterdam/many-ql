package org.fugazi.qls.type_checker;

import org.fugazi.ql.type_checker.issue.ASTNodeIssue;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestCheckerCorrectQlsForm extends QlsTypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.qlsFileName = "correctForm.qls";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = qlsChecker.isFormCorrect();
        assertTrue(formCorrect);
    }

    @Test
    public void testNoErrors() throws Exception {
        List<ASTNodeIssue> errors = qlsChecker.getErrors();
        assertTrue(errors.isEmpty());
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeIssue> warnings = qlsChecker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
