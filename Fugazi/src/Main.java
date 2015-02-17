import org.fugazi.ast.ASTBuilder;
import org.fugazi.ast.form.Form;

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

        // TODO: type checking.
//        ErrorManager errorList = typeChecker.checkForm();
//
//        if errorList.length() {
//            print errors;
//            return 1;
////        }
//
//        ErrorManager err = new ErrorManager();
//        TypeCheckError typeCheckError = new Typeckcker(err);
//
//        TypeCheckError.check(form);
//
//        Iterable typechecker.getErrorList();
//
//        if typechecker.isformvalid():
//        //show...
//        else:
//        // exit 1
        
        // TODO: evaluation.
        
        // TODO: Render GUI.
    }
}