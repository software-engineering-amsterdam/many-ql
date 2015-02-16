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
public class ExampleQuestions {

    public static Question q1(){
        Id id = new Id("question1");
        AnswerSet answerSet = new AnswerSet();
        answerSet.add(new Answer("This is an answer"));
        answerSet.add(new Answer("This is also an answer"));
        Text text = new Text("This is a question, that is even more long!?");

        Question q = new Question(id, Type.SET, answerSet, text, null, null);
        return q;
    }

    public static Question q2(){
        Id id = new Id("question2");

        Text text = new Text("Gimme all the datez?");

        Question q = new Question(id, Type.DATE, null, text, null, null);
        return q;
    }

    public static Question q3(){
        Id id = new Id("question3");
        AnswerSet answerSet = new AnswerSet();
        answerSet.add(new Answer("Yes"));
        answerSet.add(new Answer("Maybe"));
        answerSet.add(new Answer("No"));
        Text text = new Text("Do you like diz?");

        Question q = new Question(id, Type.SET, answerSet, text, null, null);
        return q;
    }

    public static Question q4(){
        Id id = new Id("question4");
        AnswerSet answerSet = new AnswerSet();
        answerSet.add(new Answer("Example Answer"));
        Text text = new Text("This is a question, that is even more long!?");

        Question q = new Question(id, Type.STRING, answerSet, text, null, null);
        return q;
    }

    public static Question q5(){
        Id id = new Id("question5");
        AnswerSet answerSet = new AnswerSet();
        answerSet.add(new Answer("So n grote Feuerball!"));
        answerSet.add(new Answer("BAM"));
        Text text = new Text("New Kids?");

        Question q = new Question(id, Type.SET, answerSet, text, null, null);
        return q;
    }
}
