import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.form_data.QLFormDataStorage;
import org.fugazi.ql.type_checker.QLTypeChecker;
import org.fugazi.ql.type_checker.issue.ASTIssuePrinter;

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
          * --------------------- */
        // Create The AST Builder.
        QLASTBuilder QLAstBuilder = new QLASTBuilder(qlInput);

        // Build the AST.
        Form form = QLAstBuilder.buildForm();
        QLFormDataStorage formDataStorage = new QLFormDataStorage(form);

        // Perform type checking.
        QLTypeChecker QLTypeChecker = new QLTypeChecker();
        boolean isFormTypesCorrect = QLTypeChecker.checkForm(form, formDataStorage);

        // display warnings and errors and if form is not type-correct, exit
        ASTIssuePrinter printer = new ASTIssuePrinter(
                QLTypeChecker.getErrors(), QLTypeChecker.getWarnings()
        );
        printer.displayWarningsAndErrors();

        if (!isFormTypesCorrect) {
            System.err.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }

        // Render GUI.
//        UIBuilder guiBuilder = new UIBuilder(form);
//        guiBuilder.renderGUI();

        /** ---------------------
         * QLS
         * --------------------- */
//        String inputQLSFile = null;
//
//        if (args.length > 1)
//            inputQLSFile = args[1];
//
//        InputStream qlsInput = System.in;
//
//        if (inputQLFile != null)
//            qlsInput = new FileInputStream(inputQLSFile);
//
//         // Create The AST Builder.
//        QLSASTBuilder qlsAstBuilder = new QLSASTBuilder(qlsInput);
//
//        // Build the AST.
//        StyleSheet styleSheet = qlsAstBuilder.buildStyleSheet();

        // todo: type checker.
        // todo: render gui with stylesheet.

    }
}