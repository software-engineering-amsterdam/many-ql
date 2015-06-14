package nl.uva.bromance;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import nl.uva.bromance.QL.ast.QLParseTreeListener;
import nl.uva.bromance.QL.gui.QLGUI;
import nl.uva.bromance.grammar.QL.QLLexer;
import nl.uva.bromance.grammar.QL.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        QLLexer lexer = null;
        try {
            lexer = new QLLexer(new ANTLRInputStream(this.getClass().getResourceAsStream("GrammarTest.ql")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TokenStream tokenStream = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokenStream);
        ParseTree tree = parser.questionnaire();
        QLParseTreeListener qlListener = new QLParseTreeListener();
        ParseTreeWalker qlWalker = new ParseTreeWalker();
        qlWalker.walk(qlListener, tree);

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

        String stylesheets = this.getClass().getResource("style.css").toExternalForm();

        QLGUI gui = new QLGUI(primaryStage,stylesheets,qlListener.getAST());
        gui.render();

        /*
        this.stage = primaryStage;
        createBaseView();
        stage.setScene(scene);
        stage.show();
        */
    }
}