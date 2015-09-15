package nl.uva.bromance.QL.gui;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.QL.ast.AST;
import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLParseTreeListener;
import nl.uva.bromance.grammar.QL.QLLexer;
import nl.uva.bromance.grammar.QL.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class QLGUI {

    private AST<QLNode> ast;
    private Stage stage;
    private VBox questionArea;
    private String stylesheets;
    private boolean debug;

    public QLGUI(Stage stage,String stylesheets,Boolean debug){
        this.stage = stage;
        this.ast = null;
        this.stylesheets = stylesheets;
        this.debug = debug;
        MenuBar menuBar = createMenuBar();
        createBaseView();
    }

    private void createBaseView() {
        VBox rootBox = new VBox();
        questionArea = new VBox();

        Scene scene = new Scene(rootBox, 650, 800);

        MenuBar menuBar = createMenuBar();

        rootBox.getChildren().addAll(menuBar, questionArea);

        scene.getStylesheets().add(stylesheets);
        stage.setScene(scene);
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem filePicker = new MenuItem("Open");

        createOpenMenuItemHandler(filePicker);

        menuFile.getItems().add(filePicker);
        menuBar.getMenus().add(menuFile);
        return menuBar;
    }

    private void createOpenMenuItemHandler(MenuItem filePicker) {
        filePicker.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                String qlPath = file.getAbsolutePath();
                try {
                    InputStream is = new FileInputStream(qlPath);
                    QLLexer lexer = new QLLexer(new ANTLRInputStream(is));
                    TokenStream tokenStream = new CommonTokenStream(lexer);
                    QLParser parser = new QLParser(tokenStream);
                    ParseTree tree = parser.questionnaire();
                    QLParseTreeListener qlListener = new QLParseTreeListener();
                    ParseTreeWalker qlWalker = new ParseTreeWalker();
                    qlWalker.walk(qlListener, tree);
                    AST<QLNode> qlAst = qlListener.getAST();
                    if (qlAst != null) {
                        this.ast = qlAst;
                        createBaseView();
                        render();
                    }
                    if (debug)
                        showDebugWindow(tree, parser);
                } catch (Exception e) {
                    System.err.println("Got error opening file : " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
    private void showDebugWindow(ParseTree tree, QLParser parser){
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

    public void render(){
        QLGuiVisitor visitor = new QLGuiVisitor(questionArea);
        if (ast != null)
            ast.getRoot().accept(visitor);
        stage.show();
    }
}
