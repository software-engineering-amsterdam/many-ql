package com.klq.logic;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question {
    private Id id;
    private Type type;
    private AnswerSet answerSet;
    private Text text;
    private Question requires;
    private AnswerSet only;

    public Question (Id id, Type type, AnswerSet answerSet, Text text, Question requires, AnswerSet only){
        this.id = id;
        this.type = type;
        this.answerSet = answerSet;
        this.text = text;
        this.requires = requires;
        this.only = only;
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
