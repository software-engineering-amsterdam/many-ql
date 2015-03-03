package org.fugazi.ql.type_checker;

import org.fugazi.ql.type_checker.error.ASTNodeError;
import org.fugazi.ql.type_checker.error.ASTNodeErrorType;
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
        List<ASTNodeError> errors = checker.getErrors();

        assertFalse(errors.isEmpty());
        // will report also undefined question
        assertEquals(2, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeError> errors = checker.getErrors();

        List<ASTNodeErrorType> expectedTypes = new ArrayList<>();
        List<ASTNodeErrorType> receivedTypes = new ArrayList<>();
        expectedTypes.add(ASTNodeErrorType.ERROR.UNDEFINED);
        expectedTypes.add(ASTNodeErrorType.ERROR.TYPE_MISMATCH);

        for (ASTNodeError error: errors) {
            receivedTypes.add(error.getErrorType());
        }
        // no custom arrayEquals method
        assertEquals(expectedTypes.size(), receivedTypes.size());
        for (ASTNodeErrorType expected : expectedTypes) {
            assertTrue(receivedTypes.contains(expected));
        }
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeError> warnings = checker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
