package nl.uva.bromance.QL.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.uva.bromance.QL.ast.AST;
import nl.uva.bromance.QL.ast.QLNode;

import java.io.File;
import java.util.Optional;

public class QLGUI {

    private AST<QLNode> ast;
    private Stage stage;
    private VBox questionArea;
    private String stylesheets;

    public QLGUI(Stage stage,String stylesheets, AST<QLNode> ast){
        this.stage = stage;
        this.ast = ast;
        this.stylesheets = stylesheets;
        MenuBar menuBar = createMenuBar();
        createBaseView();
    }

    private void createBaseView() {
        VBox rootBox = new VBox();
        questionArea = new VBox();

        Scene scene = new Scene(rootBox, 400, 800);

        MenuBar menuBar = createMenuBar();

        rootBox.getChildren().addAll(menuBar,questionArea);

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
                String qlsPath = file.getAbsolutePath().replace(".ql", ".qls");

                try {
                    /*
                    AST<QLNode> qlAst = createQlAst(qlPath);
                    vis = new Visualizer();
                    pages.getChildren().clear();
                    questions.getChildren().clear();
                    if (qlAst != null) {
                        AST<QLSNode> qlsAst = createQlsAst(qlsPath, qlAst);
                        if (qlsAst != null) {
                            vis.setQlsAst(qlsAst);
                        }
                        vis.render(qlAst, pages, questions);
                    }
                    */
                    // TODO FIX Pokemon Exception Handling
                } catch (Exception e) {
                    System.err.println("Got error : "+e.getMessage());
                }
            }
        });
    }

    public void render(){
        QLGuiVisitor visitor = new QLGuiVisitor(questionArea);
        ast.getRoot().accept(visitor);
        stage.show();
    }
}
