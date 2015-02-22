package com.klq.gui;

import com.klq.logic.AnswerSet;
import com.klq.logic.Question;
import com.sun.javafx.scene.EnteredExitedHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.time.LocalDate;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPane extends GridPane {
    private final static Font DEFAULT_QUESTION = new Font("Arial Bold", 14);
    private final static Font DEFAULT_ANSWER = new Font("Arial", 12);

    public QuestionPane(Question question) {
        super();
        createQuestionLabel(question.getText().toString());
        switch (question.getType()) {
            case SET:
            case BOOLEAN:
                createAnswerSetPane(question.getAnswerSet());
                break;
            case DATE:
                createDatePicker(question.getAnswerSet());
                break;
            case CURRENCY:
            case NUMERAL:
            case STRING:
                createTextField(question.getAnswerSet());
                break;
        }
        this.setVgap(5);
        this.setPadding(new Insets(5));
        this.setBorder(createBorder());
        this.setBackground(createBackground());
    }

    private void createQuestionLabel(String text) {
        Label question = new Label(text);
        question.setWrapText(true);
        question.setFont(DEFAULT_QUESTION);
        this.setConstraints(question, 0, 0);
        this.getChildren().add(question);
    }

    private void createAnswerSetPane(AnswerSet answerSet){
        ToggleGroup group = new ToggleGroup();
        for (int i=0; i< answerSet.size(); i++) {
            Object a = answerSet.get(i);
            RadioButton rb = new RadioButton(a.toString());
            rb.setWrapText(true);
            rb.setFont(DEFAULT_ANSWER);
            rb.setToggleGroup(group);
            rb.setSelected(false);
            this.getChildren().add(rb);
            this.setConstraints(rb, 0, i+1);
        }
    }

    private void createDatePicker(AnswerSet answerSet){
        Label dateLabel = new Label("Please select a date:");
        dateLabel.setWrapText(true);
        this.getChildren().add(dateLabel);
        this.setConstraints(dateLabel, 0, 1);

        final DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePicker.getValue();
                setAnswer(date.toString());
            }
        });
        this.getChildren().add(datePicker);
        this.setConstraints(datePicker, 0, 2);
    }

    private void createTextField(AnswerSet answerSet){
        final TextField input = new TextField();

        if (answerSet != null) {
            input.setPromptText(answerSet.get(0).toString());
        }
        input.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                input.selectAll();
            }
        });
        this.getChildren().add(input);
        this.setConstraints(input, 0, 1);
    }


    final CornerRadii RADII = new CornerRadii(10, 0.05, 0.05, 10, 10, 0.05, 0.05, 10,
            false, true, true, false, false, true, true, false);
    private Border createBorder() {
        BorderStroke stroke = new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, RADII, BorderWidths.DEFAULT);
        return new Border(stroke);
    }

    private Background createBackground() {
        BackgroundFill fill = new BackgroundFill(Paint.valueOf("#EEEEEE"), RADII, new Insets(1));
        return new Background(fill);
    }

    private void setAnswer(String answer){
        //TODO
    }
}
