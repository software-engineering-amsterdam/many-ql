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

public class TestCheckerNonBoolConditionsTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "nonBoolConditions.ql";
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
        assertEquals(1, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeError> errors = checker.getErrors();

        List<ASTNodeErrorType> expectedTypes = new ArrayList<>();
        List<ASTNodeErrorType> receivedTypes = new ArrayList<>();
        expectedTypes.add(ASTNodeErrorType.ERROR.NON_BOOL_CONDITION);

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
