package com.klq.logic.question;

import com.klq.logic.IKLQItem;
import com.klq.logic.controller.Store;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.terminal.Date;
import com.klq.logic.expression.terminal.Number;

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

    private Store store;

    public Question (Id id, Type type, OptionSet options, Text text){
        this.id = id;
        this.type = type;
        this.options = options;
        this.text = text;
        dependencies = new ArrayList<AExpression>();
        this.store = null;
    }

    public Question(Id id, Type type, OptionSet options, Text text, AExpression result) {
        this (id, type, options, text);
        this.result = result;
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

    public List<AExpression> getDependencies() {
        return dependencies;
    }

    public void addDependency(AExpression dependency){
        dependencies.add(dependency);
    }

    public boolean updateDependency(AExpression oldExpr, AExpression newExpr){
        return dependencies.remove(oldExpr) && dependencies.add(newExpr);
    }

    public boolean dependenciesResolved(){
        for (AExpression dependency : dependencies) {
            if (dependency != Boolean.getTrue())
                return false;
        }
        return true;
    }

    public void setResult(AExpression result) {
        this.result = result;
        store.update(getId());
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

    public static AExpression createTerminalFromString(Question question, String result){
        AExpression newExpr = null;
        switch (question.getType()){
            case BOOLEAN:
                if ("True".equals(question.getResult()))
                    newExpr = Boolean.getTrue();
                else
                    newExpr = Boolean.getFalse();
                break;
            case DATE:
                String[] split = result.split("[\\./-]");
                String year, month, day;
                if (split[0].length() == 4){
                    year = split[0];
                    month = split[1];
                    day = split[2];
                } else {
                    day = split[0];
                    month = split[1];
                    year = split[2];
                }
                newExpr = new Date(year + "-" + month + "-" + day);
                break;
            case NUMERAL:
                newExpr = new Number(result);
                break;
            case STRING:
                newExpr = new com.klq.logic.expression.terminal.String(result);
                break;
        }
        return newExpr;
    }
}
