package nl.uva.bromance.QL.gui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.QL.ast.AST;
import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLParseTreeListener;
import nl.uva.bromance.QL.exceptions.QLError;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.TypeChecker;
import nl.uva.bromance.grammar.QL.QLLexer;
import nl.uva.bromance.grammar.QL.QLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class QLGUI {

    private AST<QLNode> ast;
    private Stage stage;
    private VBox questionArea;
    private String stylesheets;
    private Map<String, Primitive> answerMap;
    private UUID focusUuid;
    private Node focusedNode;

    public QLGUI(Stage stage, String stylesheets) {
        this.stage = stage;
        this.ast = null;
        this.stylesheets = stylesheets;
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
                //TODO: Too much nesting.
                try {
                    InputStream is = new FileInputStream(qlPath);
                    QLLexer lexer = new QLLexer(new ANTLRInputStream(is));
                    TokenStream tokenStream = new CommonTokenStream(lexer);
                    QLParser parser = new QLParser(tokenStream);
                    GrammarErrorListener errorListener = new GrammarErrorListener();
                    List<QLError> syntaxErrors = new ArrayList<>();
                    parser.addErrorListener(errorListener);
                    ParseTree tree = parser.questionnaire();
                    errorListener.appendSyntaxErrors(syntaxErrors);
                    QLParseTreeListener qlListener = new QLParseTreeListener();
                    ParseTreeWalker qlWalker = new ParseTreeWalker();
                    qlWalker.walk(qlListener, tree);

                    AST<QLNode> qlAst = qlListener.getAST();
                    if (syntaxErrors.isEmpty() && qlAst != null) {
                        this.ast = qlAst;
                        this.answerMap = qlListener.getIdentifierMap();
                        createBaseView();
                        render();
                    } else {
                        showAlert(syntaxErrors);

                    }
                } catch (Exception e) {
                    System.err.println("Got error opening file : " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void showAlert(List<QLError> list) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Your file contains: "+list.size()+" error's/warning's.");
        addScrollAblePaneToAlert(QLError.qlErrorListToString(list), alert);
        alert.show();
    }

    private void addScrollAblePaneToAlert(String exceptionText, Alert alert){
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);

        alert.getDialogPane().setExpandableContent(expContent);
    }

    public void render() {
        renderWithFocus(null);
    }

    public void renderWithFocus(UUID uuid) {
        this.focusUuid = uuid;
        if (ast != null) {
            questionArea.getChildren().clear();

            TypeChecker typeChecker = new TypeChecker();
            List<QLError> typeCheckingErrors = typeChecker.check(ast.getRoot());

            if (typeCheckingErrors.isEmpty()) {
                QLGuiVisitor visitor = new QLGuiVisitor(questionArea, answerMap, this, ast.getRoot());
                ast.getRoot().accept(visitor);
            } else {
                showAlert(typeCheckingErrors);
            }

            if (this.focusedNode != null)
                this.focusedNode.requestFocus();
        }
        stage.show();
    }

    public UUID getFocusUuid() {
        return this.focusUuid;
    }

    public void setFocusedNode(Node node) {
        this.focusedNode = node;
    }


}
