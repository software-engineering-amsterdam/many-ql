package nl.uva.bromance;

import javafx.stage.Stage;
import nl.uva.bromance.AST.Root;
import nl.uva.bromance.typechecking.TypeChecker;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import nl.uva.bromance.visualization.Visualizer;
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

    public void run(Stage primaryStage) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("GrammarTest.ql")));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        ParseTree tree = parser.questionnaire();
        QLParseTreeListener listener = new QLParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        Root ast = listener.getAst();
        TypeChecker tc = new TypeChecker(ast);
        tc.runChecks();

        new Visualizer().visualize(ast, primaryStage);

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
