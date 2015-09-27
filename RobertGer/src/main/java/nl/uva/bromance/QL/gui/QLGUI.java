package nl.uva.bromance.QL.gui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.QL.ast.AST;
import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLParseTreeListener;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.TypeChecker;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;
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
import java.util.*;

public class QLGUI {

    private AST<QLNode> ast;
    private Stage stage;
    private VBox questionArea;
    private String stylesheets;
    private boolean debug;
    private Map<String, Primitive> answerMap;
    private UUID focusUuid;
    private Node focusedNode;

    public QLGUI(Stage stage, String stylesheets, Boolean debug) {
        this.stage = stage;
        this.ast = null;
        this.stylesheets = stylesheets;
        this.debug = debug;
        this.focusUuid = null;
        createBaseView();
    }

    private void createBaseView() {
        VBox rootBox = new VBox();
        rootBox.setMaxWidth(650);
        rootBox.setMinWidth(650);
        rootBox.setMinHeight(800);
        rootBox.setMaxHeight(800);

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
                    GrammarErrorListener errorListener = new GrammarErrorListener();
                    List<GrammarErrorListener.SyntaxError> syntaxErrors = new ArrayList<>();
                    parser.addErrorListener(errorListener);
                    ParseTree tree = parser.questionnaire();
                    errorListener.appendSyntaxErrors(syntaxErrors);
                    QLParseTreeListener qlListener = new QLParseTreeListener();
                    ParseTreeWalker qlWalker = new ParseTreeWalker();
                    qlWalker.walk(qlListener, tree);

                    if (syntaxErrors.isEmpty()) {
                        AST<QLNode> qlAst = qlListener.getAST();
                        if (qlAst != null) {
                            this.ast = qlAst;
                            this.answerMap = qlListener.getIdentifierMap();
                            createBaseView();
                            render();
                        }
                        if (debug) {
                            showDebugWindow(tree, parser);
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText(syntaxErrorToString(syntaxErrors));
                        alert.show();
                    }
                } catch (Exception e) {
                    System.err.println("Got error opening file : " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void showDebugWindow(ParseTree tree, QLParser parser) {
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

    public void render() {
        renderWithFocus(null);
    }

    public void renderWithFocus(UUID uuid) {
        this.focusUuid = uuid;
        if (ast != null) {
            questionArea.getChildren().clear();

            TypeChecker typeChecker = new TypeChecker();
            List<TypeCheckingError> typeCheckingErrors = typeChecker.check(ast.getRoot());

            if (typeCheckingErrors.isEmpty()) {
                QLGuiVisitor visitor = new QLGuiVisitor(questionArea, answerMap, this, ast.getRoot());
                ast.getRoot().accept(visitor);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(typeCheckingErrorToString(typeCheckingErrors));
                alert.show();
            }

            if (this.focusedNode != null)
                this.focusedNode.requestFocus();
        }
        stage.show();
    }

    private String syntaxErrorToString(List<GrammarErrorListener.SyntaxError> exceptions) {
        String result = "";

        for (GrammarErrorListener.SyntaxError t : exceptions) {
            result += t.getMessage() + '\n';
        }
        return result;
    }

    private String typeCheckingErrorToString(List<TypeCheckingError> exceptions) {
        String result = "";

        for (TypeCheckingError t : exceptions) {
            result += t.getMessage() + '\n';
        }
        return result;
    }

    public UUID getFocusUuid() {
        return this.focusUuid;
    }

    public void setFocusedNode(Node node) {
        this.focusedNode = node;
    }
}
