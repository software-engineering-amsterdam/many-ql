package com.klq.gui;

import com.klq.logic.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
        Id id = new Id("question1");
        AnswerSet answerSet = new AnswerSet();
        answerSet.add(new Answer("This is an answer"));
        answerSet.add(new Answer("This is also an answer"));
        Text text = new Text("This is a question, that is even more long!?");

        Question q1 = new Question(id, Type.SET, answerSet, text, null, null);
        QuestionPane questionPane = new QuestionPane(q1);

        GridPane root = new GridPane();
        //questionPane.setStyle("-fx-background-color: black;");

        primaryStage.setTitle("Test");

        root.getChildren().add(questionPane);

        root.setConstraints(questionPane, 0, 0);
        primaryStage.setScene(new Scene(root, 250, 300));
        primaryStage.show();

    }
}
