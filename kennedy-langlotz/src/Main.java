import com.klq.ast.ParseTreeConverter;
import com.klq.ast.ASTPrinter;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import parser.*;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Timon on 09.02.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
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

        //Visitor visitor = new Visitor();
        //eval.getAst().accept(visitor);

        //print AST for test purposes
        ASTPrinter printer = new ASTPrinter();
        eval.getAst().accept(printer);

        //visitor.getQuestList();

//        for (ANode child : eval.getAst().getChildren()){
//            child.printSelf();
//        }
    }
}
