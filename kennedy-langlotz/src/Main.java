import AST.Node;
import AST.ParseTreeConverter;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import parser.*;
import AST.KLQNodes.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Timon on 09.02.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("start running");
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        KLQLexer lexer = new KLQLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KLQParser parser = new KLQParser(tokens);
        ParseTree tree = parser.questionnaire();

        ParseTreeConverter eval = new ParseTreeConverter();
        eval.visit(tree);
        for (Node child : eval.getAst().getChildren()){
            child.printSelf();
        }
        System.out.println("done running");
    }
}
