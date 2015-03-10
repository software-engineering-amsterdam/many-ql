package nl.uva.bromance;

import javafx.stage.Stage;
import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.conditionals.ExpressionEvaluator;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.listeners.QLSParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import nl.uva.bromance.parsers.QLSLexer;
import nl.uva.bromance.parsers.QLSParser;
import nl.uva.bromance.typechecking.TypeChecker;
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
        Visualizer vis = new Visualizer(primaryStage);
        vis.setBaseView();
        vis.render();
    }
}
