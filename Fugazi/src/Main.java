import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.gui.widgets.WidgetsFactory;
import org.fugazi.ql.type_checker.QLTypeChecker;
import org.fugazi.ql.type_checker.issue.ASTIssuePrinter;
import org.fugazi.qls.ast.DefaultStyleHandler;
import org.fugazi.qls.ast.QLSASTBuilder;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.QLSWidgetsFactory;
import org.fugazi.qls.gui.StyledGUIBuilder;
import org.fugazi.qls.type_checker.QLSTypeChecker;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputQLFile = null;

        if (args.length > 0)
            inputQLFile = args[0];

        InputStream qlInput = System.in;

        if (inputQLFile != null)
            qlInput = new FileInputStream(inputQLFile);

        /** ---------------------
          * QL
          * ---------------------
         **/
        // Create The AST Builder.
        QLASTBuilder qLAstBuilder = new QLASTBuilder(qlInput);

        // Build the AST.
        Form form = qLAstBuilder.buildForm();

        QLFormDataStorage formDataStorage = new QLFormDataStorage(form);

        // Perform type checking.
        QLTypeChecker qLTypeChecker = new QLTypeChecker(form, formDataStorage);
        boolean isFormTypesCorrect = qLTypeChecker.checkForm();

        // display warnings and errors and if form is not type-correct, exit
        ASTIssuePrinter printer = new ASTIssuePrinter();
        printer.displayWarningsAndErrors(
                qLTypeChecker.getErrors(), qLTypeChecker.getWarnings()
        );

        if (!isFormTypesCorrect) {
            System.err.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }        

        /** ---------------------
         * QLS
         *  ---------------------
         */
        if (args.length > 1) {
            String inputQLSFile = null;
            inputQLSFile = args[1];

            InputStream qlsInput = System.in;

            if (inputQLFile != null)
                qlsInput = new FileInputStream(inputQLSFile);

            // Create The AST Builder.
            QLSASTBuilder qlsAstBuilder = new QLSASTBuilder(qlsInput);

            // Build the AST.
            StyleSheet styleSheet = qlsAstBuilder.buildStyleSheet();

            // Get the styles.
            DefaultStyleHandler defaultStyleDeclaration =
                    new DefaultStyleHandler(formDataStorage, styleSheet);
            StyleSheet styledStyleSheet = defaultStyleDeclaration.getStylesheetWithStyles();

            QLSStyleSheetDataStorage styleSheetData = new QLSStyleSheetDataStorage(styledStyleSheet);

            // Perform QLS type checking.
            QLSTypeChecker qLSTypeChecker = new QLSTypeChecker(styleSheetData, formDataStorage);
            boolean isQLSFormTypesCorrect = qLSTypeChecker.checkStylesheet();

            // display warnings and errors and if form is not type-correct, exit
            printer = new ASTIssuePrinter();
            printer.displayWarningsAndErrors(qLSTypeChecker.getErrors(), qLSTypeChecker.getWarnings());

            if (!isQLSFormTypesCorrect) {
                System.err.println("Stylesheet is not type correct. Cannot evaluate and render. Please fix the errors.");
                System.exit(-1);
            }

            // QLS
            QLSWidgetsFactory qlsWidgetsFactory = new QLSWidgetsFactory(styleSheetData);
            StyledGUIBuilder styledGUIBuilder = new StyledGUIBuilder(form, qlsWidgetsFactory, styleSheetData);
            styledGUIBuilder.renderUI();

        } else {

            // QL
            GUIBuilder guiBuilder = new GUIBuilder(form, new WidgetsFactory());
            guiBuilder.renderUI();
        }
    }
}