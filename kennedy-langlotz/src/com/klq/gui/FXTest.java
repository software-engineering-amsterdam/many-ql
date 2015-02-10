package com.klq.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Timon on 10.02.2015.
 */
public class FXTest extends Application {
    private final static Font DEFAULT = new Font("Arial Bold", 14);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello, World!");
            }
        });
        GridPane root = new GridPane();
        root.getChildren().add(btn);
        Label label = new Label("Test Label");
        label.setFont(DEFAULT);
        root.getChildren().add(label);
        root.setConstraints(label, 1, 1);
        root.setConstraints(btn, 1, 2);
        primaryStage.setScene(new Scene(root, 250, 300));
        primaryStage.show();

    }
}
