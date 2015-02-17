package com.klq.gui;

import com.klq.logic.Question;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class Questionnaire extends Application {
    private VBox vbox;
    private List<Question> questions;

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<Question>();
        questions.add(ExampleQuestions.q1());
        questions.add(ExampleQuestions.q2());
        questions.add(ExampleQuestions.q3());
        questions.add(ExampleQuestions.q4());
        questions.add(ExampleQuestions.q5());

        Questionnaire questionnaire = new Questionnaire(questions);
        launch(args);
    }

    public Questionnaire(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public void init() throws Exception {
        super.init();
        vbox = new VBox(5);
        for (Question q : questions) {
            vbox.getChildren().add(new QuestionPane(q));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Questionnaire");
        primaryStage.setScene(new Scene(vbox, 250, 300));
        primaryStage.show();
    }
}
