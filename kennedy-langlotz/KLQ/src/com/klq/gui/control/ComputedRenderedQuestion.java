package com.klq.gui.control;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.stmt.ComputedQuestionNode;
import com.klq.controller.Controller;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.List;

/**
 * Created by Timon on 16.03.2015.
 */
public class ComputedRenderedQuestion extends ARenderedQuestion {
    private final AExpression computedExpression;
    private TextField inputField;

    public ComputedRenderedQuestion(ComputedQuestionNode question, List<AExpression> dependencies, Controller controller) {
        super(question, dependencies, controller);
        this.computedExpression = question.getComputedAnswer();
    }

    @Override
    protected Region createQuestionControl() {
        TextField field = new TextField();
        field.setDisable(true);
        this.inputField = field;
        return inputField;
    }

    @Override
    protected boolean isValidInput(String input) {
        return true;
    }

    @Override
    public boolean isComputed() {
        return true;
    }

    public AExpression getComputedExpression() {
        return computedExpression;
    }

    public void updateComputedValue(String value) {
        this.inputField.setText(value);
    }
}
