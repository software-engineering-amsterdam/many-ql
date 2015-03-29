package org.fugazi.qls;

import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.type_checker.QLTypeChecker;
import org.fugazi.ql.type_checker.issue.ASTIssuePrinter;
import org.fugazi.qls.ast.DefaultStyleHandler;
import org.fugazi.qls.ast.QLSASTBuilder;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.StyledGUIBuilder;
import org.fugazi.qls.type_checker.QLSTypeChecker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QLSApplication {

    public static final String QL_FILE_EXTENSION = "ql";
    public static final String QLS_FILE_EXTENSION = "qls";

    public static QLSApplication run(
            String _qlFileName, String _qlsFileName) 
            throws IOException, IllegalArgumentException 
    {
        return new QLSApplication(_qlFileName, _qlsFileName);
    }

    private QLSApplication(String _qlFileName, String _qlsFileName) 
            throws IOException, IllegalArgumentException 
    {
        if (!this.isFileExists(_qlFileName) || !this.isFileExists(_qlsFileName)) {
            throw new IOException();
        }

        if (!this.isTheRightExtension(_qlFileName, QL_FILE_EXTENSION)
                || !this.isTheRightExtension(_qlsFileName, QLS_FILE_EXTENSION))
        {
            throw new IllegalArgumentException();
        }

        InputStream qlInputStream = new FileInputStream(_qlFileName);
        Form qlForm = this.buildForm(qlInputStream);
        QLFormDataStorage formDataStorage = new QLFormDataStorage(qlForm);

        boolean isFormTypesCorrect = performFormTypeChecking(qlForm, formDataStorage);
        if (!isFormTypesCorrect) {
            System.err.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }

        InputStream qlsInputStream = new FileInputStream(_qlsFileName);
        StyleSheet styleSheet = this.buildStyleSheet(qlsInputStream, formDataStorage);
        QLSStyleSheetDataStorage styleSheetData = new QLSStyleSheetDataStorage(styleSheet);
        
        boolean isStyleSheetTypesCorrect = this.performStyleSheetTypeChecking(styleSheetData, formDataStorage);
        if (!isStyleSheetTypesCorrect) {
            System.err.println("Stylesheet is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }
        
        this.renderUI(qlForm, styleSheetData);
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
     * QL - QLS Helper Functions.
     */
    private void renderUI(Form _form, QLSStyleSheetDataStorage _styleSheetData) {
        GUIBuilder guiBuilder = new StyledGUIBuilder(_form, _styleSheetData);
        guiBuilder.renderUI();
    }

    private Form buildForm(InputStream _inputStream) throws IOException {
        QLASTBuilder qlAstBuilder = new QLASTBuilder(_inputStream);
        return qlAstBuilder.buildForm();
    }

    private StyleSheet buildStyleSheet(
            InputStream _inputStream, QLFormDataStorage _formDataStorage) throws IOException 
    {
        QLSASTBuilder qlsAstBuilder = new QLSASTBuilder(_inputStream);
        StyleSheet styleSheet = qlsAstBuilder.buildStyleSheet();
        DefaultStyleHandler.applyStylesToStyleSheet(_formDataStorage, styleSheet);
        return styleSheet;
    }

    private boolean performFormTypeChecking(Form _form, QLFormDataStorage _formDataStorage) {
        QLTypeChecker qLTypeChecker = new QLTypeChecker(_form, _formDataStorage);
        boolean isFormTypesCorrect = qLTypeChecker.checkForm();

        ASTIssuePrinter printer = new ASTIssuePrinter();
        printer.displayWarningsAndErrors(
                qLTypeChecker.getErrors(), qLTypeChecker.getWarnings()
        );
        return isFormTypesCorrect;
    }

    private boolean performStyleSheetTypeChecking(QLSStyleSheetDataStorage _styleSheetData, QLFormDataStorage _formDataStorage) {
        QLSTypeChecker qLSTypeChecker = new QLSTypeChecker(_styleSheetData, _formDataStorage);
        boolean isQLSFormTypesCorrect = qLSTypeChecker.checkStylesheet();

        ASTIssuePrinter printer = new ASTIssuePrinter();
        printer.displayWarningsAndErrors(
                qLSTypeChecker.getErrors(), qLSTypeChecker.getWarnings()
        );
        return isQLSFormTypesCorrect;
    }
}