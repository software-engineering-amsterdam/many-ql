package org.fugazi.type_checker;

import org.fugazi.ast.ASTBuilder;
import org.fugazi.ast.form.Form;
import org.fugazi.type_checker.error.ASTNodeError;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

@Ignore("This is a base class.")
public abstract class TypeCheckerBaseTest {

    protected TypeChecker checker;
    protected Form form;

    protected String inputFile;
    protected String fileName;
    protected String filePath;
    private final String path = "/test/org/fugazi/type_checker/test_forms/";

    @Before
    public void setupEnv() {
        // run for the passed from implementing class
        if (this.fileName == null) {
            System.err.println("Cannot run tests without a form filename passed.");
            System.exit(-1);
        }
        this.filePath = this.path.concat(this.fileName);
        this.inputFile = new File("").getAbsolutePath().concat(this.filePath);
        checker = new TypeChecker();
        ASTBuilder astBuilder = null;

        // load a form
        try {
            InputStream input = System.in;
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
            // TODO before class
            checker.checkForm(form);
    }
}
