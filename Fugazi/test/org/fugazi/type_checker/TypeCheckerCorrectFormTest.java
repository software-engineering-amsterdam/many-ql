package org.fugazi.type_checker;


import org.fugazi.type_checker.error.ASTNodeError;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TypeCheckerCorrectFormTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "correctForm.ql";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = checker.isFormCorrect();
        assertTrue(formCorrect);
    }

    @Test
    public void testNoErrors() throws Exception {
        List<ASTNodeError> errors = checker.getErrors();
        assertTrue(errors.isEmpty());
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeError> warnings = checker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
