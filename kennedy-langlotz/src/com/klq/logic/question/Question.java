package com.klq.logic.question;

import com.klq.logic.IKLQItem;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question implements IKLQItem {
    private Type type;
    private OptionSet options;
    private Text text;
    private Answer result;

    public Question (Type type, OptionSet options, Text text){
        this.type = type;
        this.options = options;
        this.text = text;
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
}
