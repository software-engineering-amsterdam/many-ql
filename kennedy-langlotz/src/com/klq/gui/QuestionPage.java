package com.klq.gui;

import com.klq.logic.Question;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPage extends ScrollPane {
    private VBox vbox;
    private List<Question> questions;

    public QuestionPage(List<Question> questions){
        super();
        this.questions = questions;
        vbox = new VBox(10);
        vbox.setPadding(new Insets(5));
        vbox.setStyle("-fx-background-color: #FFFFFF;");
        this.setContent(vbox);

        this.setFitToWidth(true);

        for (Question q : questions) {
            vbox.getChildren().add(new QuestionPane(q));
        }
    }
}
