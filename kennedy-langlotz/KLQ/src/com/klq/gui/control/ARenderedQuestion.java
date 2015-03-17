package com.klq.gui.control;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.ExpressionUtil;
import com.klq.ast.impl.expr.value.Value;
import com.klq.gui.IKLQItem;
import com.klq.controller.Store;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import java.util.Map;

/**
 * Created by Timon on 09.03.2015.
 */
public abstract class ARenderedQuestion implements IKLQItem {
    protected final Font DEFAULT_FONT = new Font("Arial", 12);
    private final double EFFECT_DURATION = 500;

    protected final Store store;
    private final String id;
    private final Type type;
    private final String text;
    private final List<AExpression> dependencies;

    protected BooleanProperty visibleProperty;

    private final VBox container;
    private final Label label;
    protected final Region renderedComponent;

    protected ARenderedQuestion(String id, Type type, String text, List<AExpression> dependencies, Store store){
        this.store = store;
        this.id = id;
        this.type = type;
        this.text = text;
        this.dependencies = dependencies;
        visibleProperty = new SimpleBooleanProperty(dependencies.isEmpty());
        container = new VBox(5);
        label = createQuestionLabel();
        renderedComponent = createQuestionControl();
        container.getChildren().add(label);
        container.getChildren().add(renderedComponent);
        container.setMinHeight(50);
        setBackground();
    }

    private Label createQuestionLabel() {
        Label result = new Label(text);
        Font font = new Font("Arial Bold", 14);
        result.setFont(font);
        result.setWrapText(true);
        return result;
    }

    private void setBackground(){
        double absRadius = 10;
        double relRadius = 0.05;
        CornerRadii radii = new CornerRadii(
                absRadius, relRadius, relRadius, absRadius,
                absRadius, relRadius, relRadius, absRadius,
                false, true, true, false, false, true, true, false
        );
        BorderStroke stroke = new BorderStroke(
                Paint.valueOf("#000000"), BorderStrokeStyle.SOLID,
                radii, BorderWidths.DEFAULT
        );
        BackgroundFill fill = new BackgroundFill(
                Paint.valueOf("#EFEFEF"), radii, new Insets(1)
        );
        container.setPadding(new Insets(5));
        container.setBorder(new Border(stroke));
        container.setBackground(new Background(fill));
    }

    /**
     * Abstract methods that need to be implemented
     */
    protected abstract Region createQuestionControl();

    protected abstract boolean isValidInput(String input);

    protected void questionAnswered(String result) {
        if (result == null || result.trim().isEmpty()){
            store.updateAnswer(id, null);
        } else if (isValidInput(result)) {
            Value expr = ExpressionUtil.createTerminalFromString(type, result);
            store.updateAnswer(id, expr);
        }
    }

    public Node getControl() {
        return container;
    }

    public String getID() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public void setVisible(boolean visible) {
        if (visibleProperty.get() == visible){
            return;
        }
        visibleProperty.set(visible);
        if (visible){
            show();
        } else {
            hide();
        }
    }

    public boolean isVisible() {
        return visibleProperty.get();
    }

    public List<AExpression> getDependencies() {
        return dependencies;
    }

    public void addDependency(AExpression dependency) {
        this.dependencies.add(dependency);
    }

    public boolean dependenciesResolved(Map<String, Value> variables) {
        for (AExpression dependency : dependencies){
            Value eval = dependency.evaluate(variables);
            if (eval.isUndefined()){
                return false;
            }
        }
        return true;
    }

    public boolean isComputed(){
        return false;
    }

    //TODO QuestionPane gets lost, if user varies to fast bewteen accepted and not accepted input.
    private void show(){
        container.setManaged(true);
        container.setVisible(true);
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
                    container.setManaged(false);
                    container.setVisible(false);
                }
        ));
        timeline.play();
    }

    private List<KeyFrame> createPositionTranslationFrames(boolean reverse){
        List<KeyFrame> result = new ArrayList<>();
        Duration first = (reverse ? new Duration(EFFECT_DURATION) : Duration.ZERO);
        Duration last = (reverse ? Duration.ZERO : new Duration(EFFECT_DURATION));
        result.add(new KeyFrame(first,
                new KeyValue(renderedComponent.translateYProperty(), -renderedComponent.getHeight())));
        result.add(new KeyFrame(last,
                new KeyValue(renderedComponent.translateYProperty(), 0)));
        return result;
    }

    private List<KeyFrame> createBlurEffectFrames(double steps, boolean reverse){
        List<KeyFrame> frames = new ArrayList<>();
        for(double i=0; i<=steps; i++){
            Duration duration = (reverse ? new Duration((1-i/steps)*EFFECT_DURATION)
                    : new Duration(i/steps*EFFECT_DURATION));
            frames.add(new KeyFrame(duration,
                            new KeyValue(renderedComponent.effectProperty(), new BoxBlur(steps-i, steps-i, 3))
                    )
            );
        }
        return frames;
    }
}
