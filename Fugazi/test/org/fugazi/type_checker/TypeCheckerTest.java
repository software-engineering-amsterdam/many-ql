package org.fugazi.type_checker;

import org.fugazi.ast.ASTBuilder;
import org.fugazi.ast.form.Form;
import org.fugazi.type_checker.error.ASTNodeError;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TypeCheckerTest {

    private TypeChecker checker;
    private Form form;

    @Before
    public void setupEnv() {
        checker = new TypeChecker();
        InputStream input = null;
        ASTBuilder astBuilder = null;

        // load a form
        try {
            String inputFile = new File("").getAbsolutePath().concat(
                    "/test/org/fugazi/type_checker/test_forms/correctForm.ql");
            System.out.println(inputFile);
            input = System.in;
            if (inputFile != null)
                input = new FileInputStream(inputFile);
            // Create The AST Builder.
            astBuilder = new ASTBuilder(input);
        } catch (IOException  ex) {
            ex.printStackTrace();
        }
            // Build the AST.
            form = astBuilder.buildForm();
            // perform type check
            checker.checkForm(form);
    }

    // for each type of error, get an assertion that bug returned from the check

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
