package org.fugazi.type_checker;

import org.fugazi.type_checker.error.ASTNodeError;
import org.fugazi.type_checker.error.ASTNodeErrorType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCheckerInvalidOperandTypesTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "invalidOperandTypes.ql";
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
        assertEquals(17, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeError> errors = checker.getErrors();

        ASTNodeErrorType expectedType = ASTNodeErrorType.ERROR.TYPE_MISMATCH;
        List<ASTNodeErrorType> receivedTypes = new ArrayList<>();

        for (ASTNodeError error: errors) {
            receivedTypes.add(error.getErrorType());
        }
        // no custom arrayEquals method
        for (ASTNodeErrorType received : receivedTypes) {
            assertTrue(receivedTypes.contains(expectedType));
        }
    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeError> warnings = checker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
