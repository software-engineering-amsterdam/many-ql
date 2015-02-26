package com.klq.gui;

import com.klq.logic.expression.AExpression;
import com.klq.logic.question.OptionSet;
import com.klq.logic.question.Question;
import com.klq.logic.question.Type;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.security.Key;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPane extends GridPane {
    private final static Font DEFAULT_QUESTION = new Font("Arial Bold", 14);
    private final static Font DEFAULT_ANSWER = new Font("Arial", 12);
    private final double MIN_HEIGHT = 50;
    private final double EFFECT_DURATION = 500;
    private TextField computedField;

    private final CornerRadii RADII = new CornerRadii(10, 0.05, 0.05, 10, 10, 0.05, 0.05, 10,
            false, true, true, false, false, true, true, false);

    private Question question;

    public QuestionPane(Question question) {
        super();
        this.question = question;
        createQuestionLabel(question.getText().toString());
        this.setVgap(5);
        this.setPadding(new Insets(5));
        this.setBorder(createBorder());
        this.setBackground(createBackground());
        this.setMinHeight(MIN_HEIGHT);
        if (question.isComputedQuestion()){
            computedField = new TextField();
            computedField.textProperty().bind(question.getResult().evaluate());
            computedField.setEditable(false);
            this.getChildren().add(computedField);
            this.setConstraints(computedField, 0, 1);
            return;
        }

        switch (question.getType()) {
            case SET:
                createAnswerSetPane(question.getOptions());
                break;
            case BOOLEAN:
                createAnswerSetPane(OptionSet.createAnswerSet(Type.BOOLEAN));
                break;
            case DATE:
                createDatePicker();
                break;
            case NUMERAL:
            case STRING:
                createTextField(question.getType());
                break;
        }
    }

    public void show(){
        if (isVisible())
            return;
        this.managedProperty().bind(this.visibleProperty());
        this.setVisible(true);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(createPositionTranslationFrames());
        timeline.getKeyFrames().addAll(createBlurEffectFrames(10));
        timeline.play();
    }

    public void hide(){
        if (!isVisible())
            return;
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

    private void createDatePicker(){
        Label dateLabel = new Label("Please select a date:");
        dateLabel.setWrapText(true);
        this.getChildren().add(dateLabel);
        this.setConstraints(dateLabel, 0, 1);

        LocalDate lDate = LocalDate.now();
        final DatePicker datePicker = new DatePicker(lDate);
        if (question.isComputedQuestion()){
            //lDate = LocalDate.parse(optionSet.get(0).toString());
            datePicker.setEditable(false);
            datePicker.getEditor().setEditable(false);
            //TODO disable button somehow
        }
        datePicker.setValue(lDate);
        datePicker.getEditor().textProperty().addListener(createInputListener(Type.DATE, datePicker));
        this.getChildren().add(datePicker);
        this.setConstraints(datePicker, 0, 2);
    }

    private void createTextField(Type questionType){
        final TextField input = new TextField();

        if (question.isComputedQuestion()) {
            input.setEditable(false);
        } else {
            input.focusedProperty().addListener(highlightHandler(input));
        }

        input.textProperty().addListener(createInputListener(questionType, input));
        this.getChildren().add(input);
        this.setConstraints(input, 0, 1);
    }

    private Border createBorder() {
        BorderStroke stroke = new BorderStroke(Paint.valueOf("#000000"),
                BorderStrokeStyle.SOLID, RADII, BorderWidths.DEFAULT);
        return new Border(stroke);
    }

    private Background createBackground() {
        BackgroundFill fill = new BackgroundFill(Paint.valueOf("#EEEEEE"), RADII, new Insets(1));
        return new Background(fill);
    }

    private List<KeyFrame> createPositionTranslationFrames(){
        List<KeyFrame> result = new ArrayList<KeyFrame>();
        result.add(new KeyFrame(Duration.ZERO,
                new KeyValue(this.translateYProperty(), -getMinHeight())));
        result.add(new KeyFrame(new Duration(EFFECT_DURATION),
                        new KeyValue(this.translateYProperty(), 0)));
        return result;
    }

    private List<KeyFrame> createBlurEffectFrames(double steps){
        List<KeyFrame> frames = new ArrayList<KeyFrame>();
        for(double i=0; i<=steps; i++){
            frames.add(
                    new KeyFrame(new Duration(i/steps*EFFECT_DURATION),
                            new KeyValue(this.effectProperty(), new BoxBlur(steps-i, steps-i, 3))
                    )
            );
        }
        return frames;
    }

    private void questionAnswered(String result) {
        AExpression expr = Question.createTerminalFromString(question, result);
        question.setResult(expr, true);
        if (question.dependenciesResolved())
            show();
        else
            hide();
    }

    private ChangeListener<Boolean> highlightHandler(final TextField input){
        return new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //TODO doesn't work yet!
                if (!oldValue)
                    input.requestFocus();
                input.selectAll();

            }
        };
    }

    private ChangeListener<String> createInputListener(final Type type, final Control control){
        return new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (InputValidator.matches(type, newValue)){
                    control.setStyle("-fx-border-color: white;");
                    control.setStyle("-fx-focus-color: #0950ff;");
                    questionAnswered(newValue);
                }
                else {
                    control.setStyle("-fx-border-color: red;");
                    control.setStyle("-fx-focus-color: red;");
                }
            }
        };
    }

    private ChangeListener<Toggle> onToggleChanged(){
        return new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                String userInput = newValue.getUserData().toString();
                questionAnswered(userInput);
            }
        };
    }
}
