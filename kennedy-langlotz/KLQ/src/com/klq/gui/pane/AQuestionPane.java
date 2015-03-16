package com.klq.gui.pane;

import com.klq.ast.impl.expr.ExpressionUtil;
import com.klq.ast.impl.expr.value.Value;
import com.klq.logic.controller.Store;
import com.klq.logic.question.Question;
import com.klq.logic.question.Type;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 09.03.2015.
 */
public abstract class AQuestionPane extends GridPane {
    protected final Font DEFAULT_FONT = new Font("Arial", 12);
    private final double EFFECT_DURATION = 500;
    private final double MIN_PANE_HEIGHT = 50;
    private final double RADIUS_ABS = 10;
    private final double RADIUS_REL = 0.05;

    protected final Store store;
    protected final Question question;

    protected Label questionText;
    protected Node inputControl;

    public AQuestionPane(Question question, Store store){
        this.question = question;
        this.store = store;
        this.questionText = createQuestionLabel();
        this.inputControl = createInputControl();
        this.getChildren().add(inputControl);
        this.setDefaultStyle();
        this.setVisibilityListener();
    }

    private void setDefaultStyle(){
        this.setVgap(5);
        this.setBackground();
        this.setMinHeight(MIN_PANE_HEIGHT);
        setConstraints(questionText, 0, 0);
        setConstraints(inputControl, 0, 1);
    }

    private void setBackground(){
        CornerRadii radii = new CornerRadii(
                RADIUS_ABS, RADIUS_REL, RADIUS_REL, RADIUS_ABS,
                RADIUS_ABS, RADIUS_REL, RADIUS_REL, RADIUS_ABS,
                false, true, true, false, false, true, true, false
        );
        BorderStroke stroke = new BorderStroke(
                Paint.valueOf("#000000"), BorderStrokeStyle.SOLID,
                radii, BorderWidths.DEFAULT
        );
        BackgroundFill fill = new BackgroundFill(
                Paint.valueOf("#EFEFEF"), radii, new Insets(1)
        );
        this.setPadding(new Insets(5));
        this.setBorder(new Border(stroke));
        this.setBackground(new Background(fill));
    }

    private void setVisibilityListener(){
        this.question.visibleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                show();
            } else {
                hide();
            }
        });
    }

    private Label createQuestionLabel() {
        String text = question.getText().toString();
        Label result = new Label(text);
        Font font = new Font("Arial Bold", 14);
        result.setFont(font);
        result.setWrapText(true);
        this.setConstraints(result, 0, 0);
        this.getChildren().add(result);
        return result;
    }

    /**
     * Creates the control where the user has to provide input.
     * Also necessary to set the handler and call questionAnswered(),
     * when answer changes!
     */
    protected abstract Node createInputControl();

    protected void questionAnswered(String result) {
        if (result == null || result.trim().isEmpty()){
            store.updateAnswer(question.getId(), null);
        } else {
            Value expr = ExpressionUtil.createTerminalFromString(question.getType(), result);
            store.updateAnswer(question.getId(), expr);
        }
    }

    //TODO QuestionPane gets lost, if user varies to fast bewteen accepted and not accepted input.
    private void show(){
        this.setManaged(true);
        this.setVisible(true);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(createPositionTranslationFrames(false));
        timeline.getKeyFrames().addAll(createBlurEffectFrames(10, false));
        timeline.play();
    }

    private void hide(){
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
        List<KeyFrame> result = new ArrayList<>();
        Duration first = (reverse ? new Duration(EFFECT_DURATION) : Duration.ZERO);
        Duration last = (reverse ? Duration.ZERO : new Duration(EFFECT_DURATION));
        result.add(new KeyFrame(first,
                new KeyValue(this.translateYProperty(), -this.getMinHeight())));
        result.add(new KeyFrame(last,
                new KeyValue(this.translateYProperty(), 0)));
        return result;
    }

    private List<KeyFrame> createBlurEffectFrames(double steps, boolean reverse){
        List<KeyFrame> frames = new ArrayList<>();
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

    /*
     * Input Validation for user input
     */
    private final String DATE_PATTERN = "\\d?\\d[\\./-]\\d?\\d[\\./-]\\d\\d\\d\\d";
    private  final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";

    public boolean matches(Type questionType, String input){
        if (input.trim().isEmpty())
            return true;
        switch (questionType){
            case NUMERAL:
                return matchesNumber(input);
            case DATE:
                return matchesDate(input);
            case STRING:
                return true;
        }
        return false;
    }

    private boolean matchesDate(String input){
        if (input.matches(DATE_PATTERN))
            return true;
        return false;
    }

    private boolean matchesNumber(String input){
        return input.matches(NUMBER_PATTERN);
    }
}
