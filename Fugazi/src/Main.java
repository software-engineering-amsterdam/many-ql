import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fugazi.ast.FugaziQLVisitor;
import org.fugazi.parser.QLLexer;
import org.fugazi.parser.QLParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputFile = null;

        if (args.length > 0)
            inputFile = args[0];

        InputStream is = System.in;

        if (inputFile != null)
            is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);

        QLLexer lexer = new QLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        ParseTree tree = parser.form();

        FugaziQLVisitor ql = new FugaziQLVisitor();
        ql.visit(tree);
    }
}