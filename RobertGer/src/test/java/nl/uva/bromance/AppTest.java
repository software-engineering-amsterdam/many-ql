package nl.uva.bromance;

import nl.uva.bromance.listeners.BurialListener;
import nl.uva.bromance.listeners.DrinkListener;
import nl.uva.bromance.listeners.ExpParseTreeListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    /*
    @Test
    public void expTest() throws IOException {

        ExpLexer lexer = new ExpLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("ExpTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        ParserRuleContext burialContext = parser.burial();
        BurialListener listener = new BurialListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, burialContext);

        assertThat(listener.getCountBurial()).isEqualTo(1);
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

    @Test
    public void treeTest() throws IOException {
        ExpLexer lexer = new ExpLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("ExpTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        ParseTree tree = parser.burial();
        ExpParseTreeListener listener = new ExpParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);
    }
*/
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
/*
    @Test
    public void showTree() throws IOException {
        ExpLexer lexer = new ExpLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("ExpTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpParser parser = new ExpParser(tokens);
        ParseTree tree = parser.field();
        ExpParseTreeListener listener = new ExpParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        //show AST in console
        System.out.println(tree.toStringTree(parser));

        //show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(
                parser.getRuleNames()), tree);
        viewer.setScale(1.5);//scale a little
        panel.add(viewer);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
    */
}
