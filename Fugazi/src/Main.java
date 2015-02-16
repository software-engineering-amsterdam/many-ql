import org.fugazi.ast.ASTBuilder;
import org.fugazi.ast.Form.Form;
import org.fugazi.ast.Statement.QuestionStatement;
import org.fugazi.ast.Statement.Statement;
import org.fugazi.ast.Type.BoolType;
import org.fugazi.ast.Type.IntType;
import org.fugazi.ast.Type.MoneyType;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.*;
import java.awt.*;

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
        
        // TODO: evaluation.
        
        // TODO: type checking.
        
        // TODO: Render GUI.
    }
}