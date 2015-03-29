package org.fugazi.ql;

import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.gui.UIFormManager;
import org.fugazi.ql.gui.ui_element.UIForm;
import org.fugazi.ql.gui.widgets.WidgetsFactory;
import org.fugazi.ql.type_checker.QLTypeChecker;
import org.fugazi.ql.type_checker.issue.ASTIssuePrinter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QLApplication {

    public static final String QL_FILE_EXTENSION = "ql";

    public static QLApplication run(String _qlFileName) throws IOException, IllegalArgumentException {
        return new QLApplication(_qlFileName);
    }

    private QLApplication(String _qlFileName) throws IOException, IllegalArgumentException {

        if (!this.isFileExists(_qlFileName)) {
            throw new IOException();
        }
        
        if (!this.isTheRightExtension(_qlFileName, QL_FILE_EXTENSION)) {
            throw new IllegalArgumentException();
        }

        InputStream qlInputStream = new FileInputStream(_qlFileName);

        Form qlForm = this.buildForm(qlInputStream);

        boolean isFormTypesCorrect = performTypeChecking(qlForm);
        if (!isFormTypesCorrect) {
            System.err.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }

        this.renderUI(qlForm);
    }

    /**
     * File management.
     */
    private boolean isFileExists(String _filename) {
        Path path = Paths.get(_filename);
        return Files.exists(path);
    }
    
    private boolean isTheRightExtension(String _filename, String _extension) {
        String fileExtension = _filename.substring(_filename.lastIndexOf(".") + 1, _filename.length());
        return fileExtension.equals(_extension);
    }

    /**
     * QL Helper Functions.
     */
    private void renderUI(Form _form) {
        GUIBuilder guiBuilder = new GUIBuilder(
                _form,
                new WidgetsFactory(),
                new UIFormManager(
                        new UIForm(_form.getName())
                )
        );
        guiBuilder.renderUI();
    }
    
    private Form buildForm(InputStream _inputStream) throws IOException {
        QLASTBuilder qlAstBuilder = new QLASTBuilder(_inputStream);
       return qlAstBuilder.buildForm();
    }
    
    private boolean performTypeChecking(Form _form) {
        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        QLTypeChecker qLTypeChecker = new QLTypeChecker(_form, formDataStorage);
        boolean isFormTypesCorrect = qLTypeChecker.checkForm();
        
        ASTIssuePrinter printer = new ASTIssuePrinter();
        printer.displayWarningsAndErrors(
                qLTypeChecker.getErrors(), qLTypeChecker.getWarnings()
        );
        return isFormTypesCorrect;
    }
}
