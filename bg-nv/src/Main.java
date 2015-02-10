import lang.ql.ast.AstNode;
import lang.ql.syntax.QLVisitorImpl;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import lang.ql.gen.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            CharStream stream = new ANTLRFileStream("src/lang/tests/formInput");
            QLLexer lexer = new QLLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            ParserRuleContext tree = parser.form();

            QLVisitorImpl visitor = new QLVisitorImpl();
            AstNode root = visitor.visit(tree);
            System.out.println(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
