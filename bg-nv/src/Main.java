import lang.ql.ast.form.Form;
import lang.ql.semantics.*;
import lang.ql.semantics.values.StringValue;
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
            Form root = (Form)visitor.visit(tree);

            PrintVisitor print = new PrintVisitor();
            print.visit(root);

            SymbolVisitor symbolVisitor = new SymbolVisitor();
            symbolVisitor.visit(root);
            SymbolTable table = symbolVisitor.getSymbolTable();

            TypeChecker typeVisitor = new TypeChecker(table);
            typeVisitor.visit(root);

            Interpreter v = new Interpreter();
            v.visit(root);

            System.out.println();
            System.out.println(print.getString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
