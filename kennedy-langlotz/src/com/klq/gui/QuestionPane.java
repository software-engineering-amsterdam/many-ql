package com.klq.gui;

import com.klq.logic.question.OptionSet;
import com.klq.logic.question.Question;
import com.klq.logic.question.Type;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
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

    private final CornerRadii RADII = new CornerRadii(10, 0.05, 0.05, 10, 10, 0.05, 0.05, 10,
            false, true, true, false, false, true, true, false);

    public QuestionPane(Question question) {
        super();
        createQuestionLabel(question.getText().toString());
        switch (question.getType()) {
            case SET:
            case BOOLEAN:
                createAnswerSetPane(question.getOptions());
                break;
            case DATE:
                createDatePicker(question.getOptions());
                break;
            case NUMERAL:
            case STRING:
                createTextField(question.getOptions(), question.getType());
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

    private void createAnswerSetPane(OptionSet optionSet){
        ToggleGroup group = new ToggleGroup();
        for (int i=0; i< optionSet.size(); i++) {
            Object a = optionSet.get(i);
            RadioButton rb = new RadioButton(a.toString());
            rb.setWrapText(true);
            rb.setFont(DEFAULT_ANSWER);
            rb.setToggleGroup(group);
            rb.setSelected(false);
            this.getChildren().add(rb);
            this.setConstraints(rb, 0, i+1);
        }
    }

    private void createDatePicker(OptionSet optionSet){
        Label dateLabel = new Label("Please select a date:");
        dateLabel.setWrapText(true);
        this.getChildren().add(dateLabel);
        this.setConstraints(dateLabel, 0, 1);

        LocalDate lDate = LocalDate.now();
        final DatePicker datePicker = new DatePicker(lDate);
        if (optionSet != null && optionSet.size() != 0){
            lDate = LocalDate.parse(optionSet.get(0).toString());
            datePicker.setEditable(false);
            datePicker.getEditor().setEditable(false);
            //TODO disable button somehow
        }
        datePicker.setValue(lDate);

        this.getChildren().add(datePicker);
        this.setConstraints(datePicker, 0, 2);
    }

    private void createTextField(OptionSet optionSet, Type questionType){
        final TextField input = new TextField();

        if (optionSet != null) {
            input.setText(optionSet.get(0).toString());
            input.setEditable(false);
        } else {
            input.setOnMouseClicked(highlightHandler(input));
        }

        if (questionType == Type.NUMERAL)
            input.addEventFilter(KeyEvent.KEY_TYPED, numFilter());

        this.getChildren().add(input);
        this.setConstraints(input, 0, 1);
    }

    private Border createBorder() {
        BorderStroke stroke = new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, RADII, BorderWidths.DEFAULT);
        return new Border(stroke);
    }

    private Background createBackground() {
        BackgroundFill fill = new BackgroundFill(Paint.valueOf("#EEEEEE"), RADII, new Insets(1));
        return new Background(fill);
    }

    private EventHandler<KeyEvent> numFilter(){
       return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCharacter().matches("[0-9\\.,]"))
                    event.consume();
            }
        };
    }

    private EventHandler<MouseEvent> highlightHandler(final TextField input){
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                input.selectAll();
            }
        };
    }

    private void setAnswer(String answer){
        //TODO
    }
}
