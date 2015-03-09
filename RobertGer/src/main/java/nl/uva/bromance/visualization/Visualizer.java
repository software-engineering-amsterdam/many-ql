package nl.uva.bromance.visualization;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.Node;
import nl.uva.bromance.ast.QLSPage;
import nl.uva.bromance.util.QLFileReader;
import nl.uva.bromance.util.QLSFileReader;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Visualizer {
    private Stage stage;
    private Scene scene;
    private VBox rootBox, pages, questions;
    private QLSPage currentPage;

    public Visualizer(Stage stage) {
        this.stage = stage;
    }

    public void render() {
        stage.setScene(scene);
        stage.show();
    }

    public void setBaseView() {
        rootBox = new VBox();

        Optional<? extends Pane> root = Optional.of(rootBox);
        scene = new Scene(root.get());
        // Setup the menuBar
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem filePicker = new MenuItem("Open");

        filePicker.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                String qlPath = file.getAbsolutePath();
                String qlsPath = file.getAbsolutePath().replace(".ql", ".qls");

                AST qlAst = null;
                AST qlsAst = null;
                try {
                    qlAst = QLFileReader.readFile(qlPath);
                    // TODO: Re enable evaluator and typechecker
                    //ExpressionEvaluator ee = new ExpressionEvaluator(ast);
                    //TypeChecker tc = new TypeChecker(ast);
                    //tc.runChecks();
                } catch (IOException e) {
                    System.err.println("Couldn't find file, show error or something");
                }
                try {
                    qlsAst = QLSFileReader.readFile(qlsPath, qlAst);
                } catch (IOException e) {
                    System.err.println("Couldn't find qls file, no biggie.");
                }
                if (qlsAst != null) {
                    visualize(qlAst.getRoot(), qlsAst.getRoot());
                } else {
                    visualize(qlAst.getRoot(), null);
                }
            }
        });

        menuFile.getItems().add(filePicker);
        menuBar.getMenus().add(menuFile);

        // Setup the split pane

        SplitPane mainPane = new SplitPane();
        mainPane.setDividerPositions(0.2f);
        mainPane.setMinSize(700, 500);

        pages = new VBox();
        questions = new VBox();

        mainPane.getItems().addAll(pages, questions);

        rootBox.getChildren().addAll(menuBar, mainPane);

        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    }

    public void visualize(Node ast, Node qlsAST) {
        setBaseView();

        Optional<? extends Pane> pagePane = Optional.of(pages);
        Optional<? extends Pane> questionPane = Optional.of(questions);

        if (qlsAST != null) {
            for (Node n : qlsAST.getChildren()) {
                if (n instanceof QLSPage) {
                    QLSPage page = (QLSPage) n;
                    if (currentPage == null) {
                        currentPage = page;
                    }

                    String identifier = page.getIdentifier();
                    Label label = new Label(identifier);
                    label.setOnMouseClicked((event) -> {
                        currentPage = page;
                        visualize(ast,qlsAST);
                    });
                    if (currentPage == page){
                        label.getStyleClass().add("active");
                        for (Node child: currentPage.getChildren()){
                            child.visualize(questionPane.get());
                        }
                    }
                    label.getStyleClass().add("pageLabel");
                    pagePane.get().getChildren().add(label);
                }
            }
        } else {
            if (ast.hasChildren()) {
                visualChildren(ast, questionPane);
            }
        }
        stage.setScene(scene);
        stage.show();
    }

    private void visualChildren(Node node, Optional<? extends Pane> parentPane) {
        for (Node child : node.getChildren()) {
            if (child.hasChildren()) {
                Optional<? extends Pane> newParent = child.visualize(parentPane.get());
                if (newParent.isPresent()) {
                    visualChildren(child, newParent);
                } else {
                    visualChildren(child, parentPane);
                }
            } else {
                child.visualize(parentPane.get());
            }
        }
    }
}

