package com.klq.logic;

/**
 * Created by Timon on 16.02.2015.
 */
public class Answer {
    private String answer;

    public static final Answer YES = new Answer("Yes");
    public static final Answer NO = new Answer("No");

    public Answer(String answer){
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}