package com.klq.gui;

import com.klq.logic.Question;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPane extends GridPane {
    private final static Font DEFAULT = new Font("Arial Bold", 14);

    private void init(String text){
        createQuestionLabel(text);
    }

    public void init(Question question) {
        init(question.getText());
        switch (question.getType()) {
            case SET:
                break;
            case BOOLEAN:
                break;
            case DATE:
                break;
            case CURRENCY:
                break;
            case STRING:
                break;
            case NUMERAL:
                break;
        }
    }

    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }

    private Label createQuestionLabel(String text) {
        Label question = new Label(text);
        question.setFont(DEFAULT);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        this.getColumnConstraints().add(column1);
        this.setConstraints(question, 1, 1);
        return question;
    }
}
