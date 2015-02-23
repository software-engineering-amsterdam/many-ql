package com.klq.logic;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question {
    private Id id;
    private Type type;
    private AnswerSet answerSet;
    private Text text;

    public Question (Id id, Type type, AnswerSet answerSet, Text text){
        this.id = id;
        this.type = type;
        this.answerSet = answerSet;
        this.text = text;
    }

    public Id getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public AnswerSet getAnswerSet() {
        return answerSet;
    }

    public Text getText() {
        return text;
    }
}
