package com.klq.logic;

/**
 * Created by Timon on 10.02.2015.
 */
public class Question {
    private String id;
    private QuestionType type;
    private Answers answers;
    private String text;
    private String requires;
    private Answers only;


    public QuestionType getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
