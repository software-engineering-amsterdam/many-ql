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

            ParseTreeWalker walker = new ParseTreeWalker();
            QLBaseListener extractor = new QLBaseListener();
            walker.walk(extractor, tree);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
