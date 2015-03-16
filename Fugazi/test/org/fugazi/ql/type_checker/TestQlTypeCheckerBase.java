package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;

import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.junit.Before;
import org.junit.Ignore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

@Ignore("This is a base class.")
public abstract class TestQlTypeCheckerBase {

    protected QLTypeChecker qlChecker;
    protected Form form;
    protected QLFormDataStorage formDataStorage;

    protected String inputFile;
    protected String fileName;
    protected String filePath;
    private final String path = "/test/org/fugazi/ql/type_checker/test_form/";

    @Before
    public void setUp() {
        // run for the passed from implementing class
        if (this.fileName == null) {
            System.err.println("Cannot run tests without a form filename passed.");
            System.exit(-1);
        }
        this.filePath = this.path.concat(this.fileName);
        this.inputFile = new File("").getAbsolutePath().concat(this.filePath);
        QLASTBuilder QLASTBuilder = null;

        // load a form
        try {
            InputStream input = System.in;
            if (inputFile != null)
                input = new FileInputStream(inputFile);
            // Create The AST Builder.
            QLASTBuilder = new QLASTBuilder(input);
        } catch     (IOException  ex) {
            ex.printStackTrace();
        }

        // Build the AST.
        this.form = QLASTBuilder.buildForm();
        this.formDataStorage = new QLFormDataStorage(this.form);

        // perform type check
        qlChecker = new QLTypeChecker(this.form, this.formDataStorage);
        qlChecker.checkForm();
    }
}
