package com.klq.gui;

import com.klq.ast.impl.expr.ExpressionUtil;
import com.klq.logic.controller.Store;
import com.klq.logic.question.OptionSet;
import com.klq.logic.question.Question;
import com.klq.logic.question.Type;
import com.klq.ast.impl.expr.value.Value;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class QuestionPane extends GridPane {
    private final static Font DEFAULT_QUESTION = new Font("Arial Bold", 14);
    private final static Font DEFAULT_ANSWER = new Font("Arial", 12);
    private final CornerRadii RADII = new CornerRadii(10, 0.05, 0.05, 10, 10, 0.05, 0.05, 10,
            false, true, true, false, false, true, true, false);
    private final double MIN_HEIGHT = 50;
    private final double EFFECT_DURATION = 500;
    private final int TEXTBOX_PREFERRED_WIDTH = 250;

    private final Store store;
    private final Question question;

    public QuestionPane(Question question, Store store) {
        super();
        this.store = store;
        this.question = question;

        init();
        createQuestionLabel();
        createQuestionBody();
    }

    private void init(){
        this.setVgap(5);
        this.setPadding(new Insets(5));
        this.setBorder(createBorder());
        this.setBackground(createBackground());
        this.setMinHeight(MIN_HEIGHT);
        this.question.visibleProperty().addListener(createVisibilityListener());
    }

    private void createQuestionLabel() {
        String text = question.getText().toString();
        Label question = new Label(text);
        question.setWrapText(true);
        question.setFont(DEFAULT_QUESTION);
        this.setConstraints(question, 0, 0);
        this.getChildren().add(question);
    }

    private void createQuestionBody(){
        if (question.isComputedQuestion()){
            TextField computedField = new TextField();
            computedField.textProperty().bind(question.computedProperty());
            computedField.setEditable(false);
            computedField.setDisable(true);
            computedField.setStyle("-fx-opacity: 0.9");
            computedField.setPrefWidth(TEXTBOX_PREFERRED_WIDTH);
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

    private void createAnswerSetPane(OptionSet optionSet){
        ToggleGroup group = new ToggleGroup();
        for (int i=0; i< optionSet.size(); i++) {
            Value answer = optionSet.get(i);
            RadioButton rb = new RadioButton(answer.getValue().toString());
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

        final DatePicker datePicker = new DatePicker();
        if (question.isComputedQuestion()){
            LocalDate lDate = LocalDate.parse(question.computedProperty().toString());
            datePicker.setEditable(false);
            datePicker.getEditor().setEditable(false);
            datePicker.setValue(lDate);
            //TODO disable button somehow
        }
        datePicker.getEditor().textProperty().addListener(createInputListener(Type.DATE, datePicker));
        question.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue)
                    datePicker.getEditor().setText("");
            }
        });
        this.getChildren().add(datePicker);
        this.setConstraints(datePicker, 0, 2);
    }

    private void createTextField(Type questionType){
        final TextField input = new TextField();
        input.setPrefWidth(TEXTBOX_PREFERRED_WIDTH);

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

    private ChangeListener<Boolean> createVisibilityListener(){
        return new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue)
                    show();
                else
                    hide();
            }
        };
    }

    //TODO QuestionPane gets lost, if user varies to fast bewteen accepted and not accepted input.
    public void show(){
        this.setManaged(true);
        this.setVisible(true);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(createPositionTranslationFrames(false));
        timeline.getKeyFrames().addAll(createBlurEffectFrames(10, false));
        timeline.play();
    }

    public void hide(){
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(createBlurEffectFrames(10, true));
        timeline.getKeyFrames().addAll(createPositionTranslationFrames(true));
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(EFFECT_DURATION),
                hide -> {
                    this.setManaged(false);
                    this.setVisible(false);
                }
        ));
        timeline.play();
    }

    private List<KeyFrame> createPositionTranslationFrames(boolean reverse){
        List<KeyFrame> result = new ArrayList<KeyFrame>();
        Duration first = (reverse ? new Duration(EFFECT_DURATION) : Duration.ZERO);
        Duration last = (reverse ? Duration.ZERO : new Duration(EFFECT_DURATION));
        result.add(new KeyFrame(first,
                new KeyValue(this.translateYProperty(), -getMinHeight())));
        result.add(new KeyFrame(last,
                new KeyValue(this.translateYProperty(), 0)));
        return result;
    }

    private List<KeyFrame> createBlurEffectFrames(double steps, boolean reverse){
        List<KeyFrame> frames = new ArrayList<KeyFrame>();
        for(double i=0; i<=steps; i++){
            Duration duration = (reverse ? new Duration((1-i/steps)*EFFECT_DURATION)
                    : new Duration(i/steps*EFFECT_DURATION));
            frames.add(new KeyFrame(duration,
                            new KeyValue(this.effectProperty(), new BoxBlur(steps-i, steps-i, 3))
                    )
            );
        }
        return frames;
    }

    private void questionAnswered(String result) {
        if (result.trim().isEmpty())
            return;

        Value expr = ExpressionUtil.createTerminalFromString(question.getType(), result);
        store.updateAnswer(question.getId(), expr);
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
                if (InputValidator.matches(type, newValue) && !newValue.equals("")){
                    control.setStyle("-fx-border-color: white;");
                    control.setStyle("-fx-focus-color: #0950ff;");
                    questionAnswered(newValue);
                }
                else {
                    control.setStyle("-fx-border-color: red;");
                    control.setStyle("-fx-focus-color: red;");
                    //questionAnswered("");
                }
            }
        };
    }

    private ChangeListener<Toggle> onToggleChanged(){
        return new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                String value = observable.getValue().toString();
                value = value.substring(value.indexOf("'")+1, value.lastIndexOf("'"));
                questionAnswered(value);
            }
        };
    }
}
