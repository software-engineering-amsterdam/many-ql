package nl.uva.bromance;

import nl.uva.bromance.listeners.BurialListener;
import nl.uva.bromance.listeners.DrinkListener;
import nl.uva.bromance.parsers.DrinkLexer;
import nl.uva.bromance.parsers.DrinkParser;
import nl.uva.bromance.parsers.ExpLexer;
import nl.uva.bromance.parsers.ExpParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void expTest() throws IOException {

        ExpLexer lexer = new ExpLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("ExpTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        ParserRuleContext burialContext = parser.getContext();
        BurialListener listener = new BurialListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, burialContext);

        assertThat(listener.getCountBurial()).isEqualTo(4);
    }

    @Test
    public void drinkTest() throws IOException {
        DrinkLexer lexer = new DrinkLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("DrinkTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DrinkParser parser = new DrinkParser(tokens);
        DrinkParser.DrinkSentenceContext drinkSentenceContext = parser.drinkSentence();
        DrinkListener listener = new DrinkListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, drinkSentenceContext);
    }
}
