package com.klq.gui;

import com.klq.logic.AnswerSet;
import com.klq.logic.Question;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPane extends GridPane {
    private final static Font DEFAULT_QUESTION = new Font("Arial Bold", 14);
    private final static Font DEFAULT_ANSWER = new Font("Arial", 12);

    public QuestionPane(Question question) {
        createQuestionLabel(question.getText().toString());
        switch (question.getType()) {
            case SET:
                createAnswersSetPane(question.getAnswerSet());
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
        question.setFont(DEFAULT_QUESTION);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        this.getColumnConstraints().add(column1);
        this.setConstraints(question, 1, 1);
        return question;
    }

    private Pane createAnswersSetPane(AnswerSet answerSet){
        GridPane pane = new GridPane();
        ToggleGroup group = new ToggleGroup();
        for (int i=0; i< answerSet.size(); i++){
            Object a = answerSet.get(i);
            RadioButton rb = new RadioButton(a.toString());
            rb.setFont(DEFAULT_ANSWER);
            rb.setToggleGroup(group);
            rb.setSelected(false);
        }
        return pane;
    }
}
