package nl.uva.bromance;

import nl.uva.bromance.listeners.ExpParseTreeListener;
import nl.uva.bromance.parsers.ExpLexer;
import nl.uva.bromance.parsers.ExpParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Robert on 2/7/2015.
 */
public class Runner {

    public void run() throws IOException {
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
        JScrollPane pane = new JScrollPane(panel);
        TreeViewer viewer = new TreeViewer(Arrays.asList(
                parser.getRuleNames()), tree);
        viewer.setScale(1.5);//scale a little
        panel.add(viewer);
        frame.getContentPane().add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
