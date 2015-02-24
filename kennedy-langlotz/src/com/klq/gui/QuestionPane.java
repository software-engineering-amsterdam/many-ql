package com.klq.gui;

import com.klq.logic.expression.AExpression;
import com.klq.logic.question.OptionSet;
import com.klq.logic.question.Question;
import com.klq.logic.question.Type;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.time.LocalDate;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPane extends GridPane {
    private final static Font DEFAULT_QUESTION = new Font("Arial Bold", 14);
    private final static Font DEFAULT_ANSWER = new Font("Arial", 12);
    private final double MIN_HEIGHT = 50;

    private final CornerRadii RADII = new CornerRadii(10, 0.05, 0.05, 10, 10, 0.05, 0.05, 10,
            false, true, true, false, false, true, true, false);

    private Question question;

    public QuestionPane(Question question) {
        super();
        this.question = question;
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
        this.setMinHeight(MIN_HEIGHT);
    }

    public void show(){
        if (isVisible())
            return;
        this.managedProperty().bind(this.visibleProperty());
        this.setVisible(true);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(this.translateYProperty(), Math.random() * -getMinHeight())
                ),
                new KeyFrame(new Duration(750),
                        new KeyValue(this.translateYProperty(), Math.random() * 0)
                )
        );
        timeline.play();
    }

    public void hide(){
        this.managedProperty().bind(this.visibleProperty());
        this.setVisible(false);
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
        group.selectedToggleProperty().addListener(onToggleChanged());
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

        datePicker.focusedProperty().addListener(onFocusChanged(datePicker.getEditor()));

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

        input.focusedProperty().addListener(onFocusChanged(input));
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
                if (!event.getCharacter().matches("[0-9\\.]"))
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

    private ChangeListener<Boolean> onFocusChanged(final TextField textField){
        return new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                    onQuestionAnswered(textField.getText());

            }
        };
    }

    private ChangeListener<Toggle> onToggleChanged(){
        return new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                onQuestionAnswered(newValue.getUserData().toString());
            }
        };
    }

    public void onQuestionAnswered(String result) {
        AExpression expr = Question.createTerminalFromString(question, result);
        question.setResult(expr);
        if (question.dependenciesResolved())
            show();
        else
            hide();
    }
}
