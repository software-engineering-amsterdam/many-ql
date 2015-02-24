package com.klq.logic.question;

import com.klq.logic.IKLQItem;
import com.klq.logic.controller.Store;
import com.klq.logic.expression.AExpression;

import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question implements IKLQItem {
    private final Id id;
    private final Type type;
    private final OptionSet options;
    private final Text text;
    private final List<AExpression> dependencies;
    private Answer result;

    private Store store;

    public Question (Id id, Type type, OptionSet options, Text text, List<AExpression> dependencies){
        this.id = id;
        this.type = type;
        this.options = options;
        this.text = text;
        this.dependencies = dependencies;
        this.store = null;
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

    public boolean updateDependency(AExpression oldExpr, AExpression newExpr){
        return dependencies.remove(oldExpr) && dependencies.add(newExpr);
    }

    public void setResult(Answer result) {
        this.result = result;
        questionAnswered();
    }

    public Answer getResult() {
        return result;
    }

    private void questionAnswered(){
        store.update(getId());
    }

    public void setStore(Store store) throws Exception{
        if (this.store == null)
            this.store = store;
        else
            throw new Exception("Store already set!");
    }
}
