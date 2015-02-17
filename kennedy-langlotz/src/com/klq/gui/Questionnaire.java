package com.klq.gui;

import com.klq.logic.Question;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class Questionnaire extends Application {
    private ScrollPane root;
    private VBox vbox;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        vbox = new VBox(5);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5));
        root = new ScrollPane(vbox);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        for (Question q : ExampleQuestions.all()) {
            vbox.getChildren().add(new QuestionPane(q));
        }

        primaryStage.setTitle("Questionnaire");
        primaryStage.setScene(new Scene(vbox, 250, 300));
        primaryStage.show();
    }
}
