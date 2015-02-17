import org.fugazi.ast.ASTBuilder;
import org.fugazi.ast.form.Form;
import org.fugazi.type_checker.TypeChecker;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputFile = null;

        if (args.length > 0)
            inputFile = args[0];

        InputStream input = System.in;

        if (inputFile != null)
            input = new FileInputStream(inputFile);

        // Create The AST BUILDER.
        ASTBuilder astBuilder = new ASTBuilder(input);
        // Build the AST.
        Form form = astBuilder.buildForm();

        // Perform type checking.
        TypeChecker typeChecker = new TypeChecker();
        boolean isFormTypeCorrect = typeChecker.checkForm(form);
        // if form is not type-correct, display warnings, errors and exit
        if (!isFormTypeCorrect) {
            System.out.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            return;
        }

        
        // TODO: evaluation.
        
        // TODO: Render GUI.
    }
}