package nl.uva.bromance.visualization;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.QLSNode;
import nl.uva.bromance.ast.QLSPage;
import nl.uva.bromance.ast.conditionals.ExpressionEvaluator;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.visitors.ConditionalHandler;
import nl.uva.bromance.listeners.GrammarErrorListener;
import nl.uva.bromance.listeners.QLParseTreeListener;
import nl.uva.bromance.listeners.QLSParseTreeListener;
import nl.uva.bromance.parsers.QLLexer;
import nl.uva.bromance.parsers.QLParser;
import nl.uva.bromance.parsers.QLSLexer;
import nl.uva.bromance.parsers.QLSParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Visualizer {
    private Stage stage;
    private Scene scene;
    private VBox rootBox, pages, questions;
    private QLSPage currentPage;
    private Map<String, Result> answerMap = new HashMap<>();
    private AST<QLNode> qlAst;
    private AST<QLSNode> qlsAst;
    private Node focusedNode;
    private int focusId;

    public void setFocusedNode(Node node) {
        this.focusedNode = node;
    }

    public int getFocusId() {
        return focusId;
    }

    public void render(Stage primaryStage) {
        createBaseView();
        stage = primaryStage;
        stage.setScene(scene);
        stage.show();
    }

    public void createBaseView() {
        rootBox = new VBox();

        Optional<? extends Pane> root = Optional.of(rootBox);
        scene = new Scene(root.get());
        MenuBar menuBar = createMenuBar();
        SplitPane mainPane = createSplitPane();

        rootBox.getChildren().addAll(menuBar, mainPane);

        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

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

                createQlAst(qlPath);
                createQlsAst(qlsPath);
                visualize(0);
            }
        });
    }

    private void createQlsAst(String qlsPath) {
        qlsAst = null;
        try {
            qlsAst = readQlsFile(qlsPath, qlAst);
        } catch (IOException e) {
            System.out.println("Couldn't find qls file, no biggie.");
        }
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

    private void createQlAst(String qlPath) {
        qlAst = null;
        try {
            qlAst = readQlFile(qlPath);
        } catch (IOException e) {
            System.err.println("Couldnt load QL file :" + qlPath);
        }
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

    //TODO: Method length is a bit much. Consider restructuring.
    public void visualize(int focusId) {
        this.focusId = focusId;
        createBaseView();

        //TODO:Think if something explicit, to know when it was a refresh.
        new ExpressionEvaluator(answerMap).evaluate(qlAst.getRoot());
        new ConditionalHandler().handle(qlAst.getRoot());

        Optional<? extends Pane> pagePane = Optional.of(pages);
        Optional<? extends Pane> questionPane = Optional.of(questions);

        //TODO: This it to long, break it up in smaller methods.
        if (qlsAst != null) {

            for (QLSNode n : qlsAst.getRoot().getChildren()) {
                if (n instanceof QLSPage) {
                    QLSPage page = (QLSPage) n;
                    if (currentPage == null) {
                        currentPage = page;
                    }

                    String identifier = page.getIdentifier();
                    Label label = new Label(identifier);
                    label.setOnMouseClicked((event) -> {
                        currentPage = page;
                        visualize(0);
                    });
                    if (currentPage == page) {
                        label.getStyleClass().add("active");
                        for (QLSNode child : currentPage.getChildren()) {
                            child.visualize(questionPane.get(), answerMap, this);
                        }
                    }
                    label.getStyleClass().add("pageLabel");
                    pagePane.get().getChildren().add(label);
                }
            }
            // Non-QLS Implementation
        } else {
            if (qlAst.getRoot().hasChildren()) {
                visualizeChildren(qlAst.getRoot(), questionPane);
            }
        }
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        if (focusedNode != null) {
            focusedNode.requestFocus();
            // Fix for the position caret in textfields, had to use instanceof sorry Tijs!
            if (focusedNode instanceof TextField) {
                TextField tf = (TextField) focusedNode;
                tf.positionCaret(tf.getLength());
            }
        }
    }

    private void visualizeChildren(QLNode node, Optional<? extends Pane> parentPane) {
        for (QLNode child : node.getChildren()) {
            if (child.hasChildren()) {
                visualizeChildren(child, parentPane);
            } else {
                child.visualize(parentPane.get(), answerMap, this);
            }
        }
    }

    public void refresh(QLNode node) {
    }
}

