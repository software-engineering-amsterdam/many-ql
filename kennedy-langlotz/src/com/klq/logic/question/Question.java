package com.klq.logic.question;

import com.klq.logic.IKLQItem;
import com.klq.logic.controller.Store;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.terminal.Date;
import com.klq.logic.expression.terminal.Number;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question implements IKLQItem{
    private final Id id;
    private final Type type;
    private final OptionSet options;
    private final Text text;
    private final List<AExpression> dependencies;
    private AExpression result;
    private boolean computedQuestion;

    private Store store;

    public Question (Id id, Type type, OptionSet options, Text text){
        this.id = id;
        this.type = type;
        this.options = options;
        this.text = text;
        dependencies = new ArrayList<AExpression>();
        this.store = null;
        computedQuestion = false;
    }

    public Question(Id id, Type type, OptionSet options, Text text, AExpression result) {
        this (id, type, options, text);
        this.result = result;
        computedQuestion = true;
    }

    public boolean isComputedQuestion() {
        return computedQuestion;
    }

    public Id getId() {
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

    public List<AExpression> getDependencyList() {
        return dependencies;
    }

    public void addDependency(AExpression dependency){
        dependencies.add(dependency);
    }

    public boolean dependenciesResolved(){
        for (AExpression dependency : dependencies) {
            if (dependency.evaluate() != Boolean.getTrue())
                return false;
        }
        return true;
    }

    public void setResult(AExpression result, boolean update) {
        if (!computedQuestion)
            this.result = result; //need to call set() for observer!
        String newValue = result.evaluate().getContent();
        this.result.set(newValue);

        if (update)
            store.update(this);
    }

    public AExpression getResult() {
        return result;
    }

    public void setStore(Store store) throws Exception{
        if (this.store == null)
            this.store = store;
        else
            throw new Exception("Store already set!");
    }

    //TODO check if this works
    public static AExpression createTerminalFromString(Question question, String result){
        switch (question.getType()){
            case BOOLEAN:
                if ("True".equals(question.getResult()))
                    return Boolean.getTrue();
                else if ("False".equals(question.getResult()))
                    return Boolean.getFalse();
                return null;
            case DATE:
                String[] split = result.split("[\\./-]");
                String year = "0000", month = "01", day = "01";
                if (split[0].length() == 4 && split[1].length() == 2 && split[2].length() == 2){
                    year = split[0];
                    month = split[1];
                    day = split[2];
                } else if (split[2].length() == 4 && split[1].length() == 2 && split[0].length() == 2){
                    day = split[0];
                    month = split[1];
                    year = split[2];
                }
                return new Date(year + "-" + month + "-" + day);
            case NUMERAL:
                return new Number(!result.isEmpty() ? result : "0");
            case STRING:
                return new com.klq.logic.expression.terminal.String(result);
        }
        return null;
    }
}
