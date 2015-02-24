package org.fugazi.type_checker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TypeCheckerTest {

    private TypeChecker checker;

    @Before
    public void setupEnv() {
        checker = new TypeChecker();

        // load a set of forms, each one with a different error
    }

    // for each type of error, get an assertion that bug returned from the check

    @Test
    public void testSampleForm() throws Exception {
        boolean value = true;
        assertTrue(value);
    }
}
