package lang.tests;

/**
 * Created by Nik on 10-2-15.
 */
import lang.ql.gen.QLBaseListener;
import lang.ql.gen.QLLexer;
import lang.ql.gen.QLParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
public class ParserTest {
    @Test
    public void testTree() {
        try
        {
            CharStream stream = new ANTLRFileStream("formInput");
            QLLexer lexer = new QLLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            ParserRuleContext tree = parser.form();

            ParseTreeWalker walker = new ParseTreeWalker();
            TestQLBaseListener listener = new TestQLBaseListener();
            walker.walk(listener, tree);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private class TestQLBaseListener extends QLBaseListener {
        //TODO
    }
}