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

public class TestCyclicDependenciesTest extends TypeCheckerBaseTest {

    @Before
    public void setUp() {
        this.fileName = "cyclicDependencies.ql";
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
        assertEquals(6, errors.size());
    }

    @Test
    public void testErrorTypes() throws Exception {
        List<ASTNodeError> errors = checker.getErrors();

        List<ASTNodeErrorType> receivedTypes = new ArrayList<>();

        for (ASTNodeError error: errors) {
            receivedTypes.add(error.getErrorType());
        }
        // we expect two of each kind
        int cyclicDeps = 0, undefined = 0, wrongAssignment = 0;
        for (ASTNodeErrorType received : receivedTypes) {
            if (received.equals(ASTNodeErrorType.ERROR.CYCLIC)) {
                cyclicDeps++;
            }  else if (received.equals(ASTNodeErrorType.ERROR.UNDEFINED)) {
                undefined++;
            }  else if (received.equals(ASTNodeErrorType.ERROR.TYPE_MISMATCH)) {
                wrongAssignment++;
            }
        }

        assertEquals(2, cyclicDeps);
        assertEquals(2, undefined);
        assertEquals(2, wrongAssignment);

    }

    @Test
    public void testNoWarnings() throws Exception {
        List<ASTNodeError> warnings = checker.getWarnings();
        assertTrue(warnings.isEmpty());
    }
}
