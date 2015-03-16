package com.klq.logic.question;

import com.klq.ast.impl.Type;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.IdentifierValue;
import com.klq.ast.impl.expr.value.Value;
import com.klq.logic.IKLQItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question implements IKLQItem{
    private final IdentifierValue id;
    private final Type type;
    private final Text text;
    private final List<AExpression> dependencies;

    private final boolean computedQuestion;
    private final AExpression computedExpression;

    private final BooleanProperty visibleProperty;
    private final StringProperty computedProperty;

    public Question(IdentifierValue id, Type type, Text text) {
        this(id, type, text, null);
    }

    public Question (IdentifierValue id, Type type, Text text, AExpression computedExpression){
        this.id = id;
        this.type = type;
        this.text = text;
        this.dependencies = new ArrayList<>();
        this.visibleProperty = new SimpleBooleanProperty(dependencies.isEmpty());
        this.computedProperty = new SimpleStringProperty("");
        if (computedExpression == null) {
            computedQuestion = false;
        } else {
            computedQuestion = true;
        }
        this.computedExpression = computedExpression;
    }

    public boolean isComputedQuestion() {
        return computedQuestion;
    }

    public IdentifierValue getID() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Text getText() {
        return text;
    }

    public void addDependency(AExpression dependency){
        dependencies.add(dependency);
    }

    public boolean dependenciesResolved(Map<String, Value> variables) {
        for (AExpression d : dependencies) {
            if (!isSatisfied(d, variables)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSatisfied(AExpression expression, Map<String, Value> variables){
        Value result = expression.evaluate(variables);

        if (result.isUndefined()) {
            return false;
        } else {
            return (boolean) result.getValue();
        }
    }

    public AExpression getComputedExpression() {
        return computedExpression;
    }

    public void setVisible(boolean visible){
        this.visibleProperty.set(visible);
    }

    public boolean isVisible(){
        return visibleProperty.get();
    }

    public BooleanProperty visibleProperty(){
        return visibleProperty;
    }

    public void setComputedValue(String value) {
        computedProperty().set(value);
    }

    public StringProperty computedProperty(){
        return computedProperty;
    }
}
