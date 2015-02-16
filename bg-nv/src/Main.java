import lang.ql.ast.AstNode;
import lang.ql.ast.form.Form;
import lang.ql.ast.SymbolTable;
import lang.ql.semantics.TypeChecker;
import lang.ql.ast.visitor.PrintVisitor;
import lang.ql.ast.visitor.SymbolVisitor;
import lang.ql.syntax.QLVisitorImpl;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

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

            PrintVisitor print = new PrintVisitor();
            print.visit((Form)root);

            SymbolVisitor symbolVisitor = new SymbolVisitor();
            SymbolTable table = symbolVisitor.visit(root);

            TypeChecker typeVisitor = new TypeChecker();
            typeVisitor.visit(root, table);

            System.out.println(root);
            System.out.println(print.getString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
