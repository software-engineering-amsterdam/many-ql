package nl.uva.bromance;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;


public class AppTest {

    @Test
    public void grammarTest() throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("GrammarTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        ParseTree tree = parser.questionnaire();
        QLParseTreeListener listener = new QLParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        System.out.println("Tree Structure : "+tree.toStringTree(parser));
    }
}
