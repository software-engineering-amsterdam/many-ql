import lang.ql.ast.AstNode;
import lang.ql.ast.symboltable.SymbolTable;
import lang.ql.ast.visitor.SymbolVisitor;
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

            SymbolVisitor symbolVisitor = new SymbolVisitor();
            SymbolTable table = symbolVisitor.visit(root);

            System.out.println(root);
            System.out.println(table);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
