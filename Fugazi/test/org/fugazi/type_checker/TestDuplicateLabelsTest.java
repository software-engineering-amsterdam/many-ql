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

/**
 * Created by lukaszharezlak on 24/02/15.
 */
public class TestDuplicateLabelsTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "duplicateLabels.ql";
        super.setUp();
    }

    @Test
    public void testFormCorrect() throws Exception {
        boolean formCorrect = checker.isFormCorrect();
        assertTrue(formCorrect);
    }

    @Test
    public void testErrorCount() throws Exception {
        List<ASTNodeError> errors = checker.getErrors();

        assertTrue(errors.isEmpty());
    }

    @Test
    public void testWarningsCount() throws Exception {
        List<ASTNodeError> warnings = checker.getWarnings();
        assertFalse(warnings.isEmpty());
        assertEquals(1, warnings.size());
    }

    @Test
    public void testWarningTypes() throws Exception {
        List<ASTNodeError> warnings = checker.getWarnings();
        assertFalse(warnings.isEmpty());

        ASTNodeErrorType expectedType = ASTNodeErrorType.WARNING.DUPLICATE_LABEL;
        List<ASTNodeErrorType> receivedTypes = new ArrayList<>();

        for (ASTNodeError warning: warnings) {
            receivedTypes.add(warning.getErrorType());
        }
        // no custom arrayEquals method
        for (ASTNodeErrorType received : receivedTypes) {
            assertTrue(received.equals(expectedType));
        }
    }
}
