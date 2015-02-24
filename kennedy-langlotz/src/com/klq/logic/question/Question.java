package com.klq.logic.question;

import com.klq.logic.IKLQItem;

import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question implements IKLQItem {
    private final Type type;
    private final OptionSet options;
    private final Text text;
    private final List<Dependency> dependencies;
    private Answer result;

    public Question (Type type, OptionSet options, Text text, List<Dependency> dependencies){
        this.type = type;
        this.options = options;
        this.text = text;
        this.dependencies = dependencies;
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

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setResult(Answer result) {
        this.result = result;
    }

    public Answer getResult() {
        return result;
    }
}
