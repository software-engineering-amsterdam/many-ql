package com.klq.logic.question;

import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.IdentifierValue;
import com.klq.logic.IKLQItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question implements IKLQItem{
    private final IdentifierValue id;
    private final Type type;
    private final OptionSet options;
    private final Text text;
    private final List<AExpression> dependencies;

    private final boolean computedQuestion;
    private final AExpression computedExpression;

    private final SimpleBooleanProperty visibleProperty;
    private final SimpleStringProperty computedProperty;

    public Question (IdentifierValue id, Type type, OptionSet options, Text text){
        this.id = id;
        this.type = type;
        this.options = options;
        this.text = text;
        this.dependencies = new ArrayList<>();
        visibleProperty = new SimpleBooleanProperty(dependencies.isEmpty());
        computedProperty = new SimpleStringProperty("");

        if (this.options != null) {
            if (this.options.size() == 1) {
                computedQuestion = true;
                computedExpression = options.get(0);
                return;
            }
        }
        computedQuestion = false;
        computedExpression = null;
    }

    public boolean isComputedQuestion() {
        return computedQuestion;
    }

    public IdentifierValue getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public OptionSet getOptions() {
        return options;
    }

    public Text getText() {
        return text;
    }

    public List<AExpression> getDependencies() {
        return dependencies;
    }

    public void addDependency(AExpression dependency){
        dependencies.add(dependency);
    }

    public AExpression getComputedExpression() {
        return computedExpression;
    }

    public BooleanProperty visibleProperty(){
        return visibleProperty;
    }

    public StringProperty computedProperty(){
        return computedProperty;
    }
}
