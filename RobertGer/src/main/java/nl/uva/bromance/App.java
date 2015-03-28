package nl.uva.bromance;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.QLSNode;
import nl.uva.bromance.ast.conditionals.ExpressionEvaluator;
import nl.uva.bromance.ast.visitors.ConditionalHandler;
import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.listeners.QLSParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import nl.uva.bromance.parsers.QLSLexer;
import nl.uva.bromance.parsers.QLSParser;
import nl.uva.bromance.visualization.Visualizer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class App extends Application {

    private Scene scene;
    private VBox rootBox, pages, questions;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        createBaseView();
        stage.setScene(scene);
        stage.show();
    }

    private void createBaseView() {
        rootBox = new VBox();

        Optional<? extends Pane> root = Optional.of(rootBox);
        scene = new Scene(root.get());
        MenuBar menuBar = createMenuBar();
        SplitPane mainPane = createSplitPane();

        rootBox.getChildren().addAll(menuBar, mainPane);

        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

        stage.show();

    }

    private SplitPane createSplitPane() {
        SplitPane mainPane = new SplitPane();
        mainPane.setDividerPositions(0.2f);
        mainPane.setMinSize(700, 500);
        mainPane.getDividers();

        pages = new VBox();
        questions = new VBox();

        mainPane.getItems().addAll(pages, questions);
        return mainPane;
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
                String qlsPath = file.getAbsolutePath().replace(".ql", ".qls");

                AST<QLNode> qlAst = createQlAst(qlPath);
                Visualizer visualizer = new Visualizer();
                if (qlAst != null) {
                    AST<QLSNode> qlsAst = createQlsAst(qlsPath, qlAst);
                    if (qlsAst != null) {
                        visualizer.setQlsAst(qlsAst);
                    }
                    visualizer.render(qlAst, pages, questions);
                }
            }
        });
    }

    private AST<QLSNode> readQlsFile(String qlsPath, AST<QLNode> qlAst) throws IOException {
        QLSLexer qlsLexer = new QLSLexer(new ANTLRFileStream(qlsPath));
        CommonTokenStream qlsTokens = new CommonTokenStream(qlsLexer);
        QLSParser qlsParser = new QLSParser(qlsTokens);
        ParseTree qlsTree = qlsParser.stylesheet();
        QLSParseTreeListener qlsListener = new QLSParseTreeListener(qlAst);

        ParseTreeWalker qlsWalker = new ParseTreeWalker();
        qlsWalker.walk(qlsListener, qlsTree);
        AST<QLSNode> ast = qlsListener.getAst();
        return ast;
    }

    private AST<QLSNode> createQlsAst(String qlsPath, AST<QLNode> qlAst) {
        AST<QLSNode> qlsAst = null;
        try {
            qlsAst = readQlsFile(qlsPath, qlAst);
        } catch (IOException e) {
            System.out.println("Couldn't find qls file, no biggie.");
        }
        return qlsAst;
    }

    private AST<QLNode> readQlFile(String qlPath) throws IOException {
        QLLexer lexer = new QLLexer(new ANTLRFileStream(qlPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new GrammarErrorListener());

        ParseTree tree = parser.questionnaire();
        QLParseTreeListener listener = new QLParseTreeListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, tree);

        AST<QLNode> qlAst = listener.getAst();

        new ExpressionEvaluator(null).evaluate(qlAst.getRoot());
        new ConditionalHandler().handle(qlAst.getRoot());

        return qlAst;
    }

    private AST<QLNode> createQlAst(String qlPath) {
        AST<QLNode> qlAst = null;
        try {
            qlAst = readQlFile(qlPath);
        } catch (IOException e) {
            System.err.println("Couldnt load QL file :" + qlPath);
        }
        return qlAst;
    }
}