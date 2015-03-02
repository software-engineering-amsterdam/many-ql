package com.klq.logic.controller;

/**
 * Created by Timon on 27.02.2015.
 */
public class NoSuchQuestionException extends Exception {

    public NoSuchQuestionException() {
        super();
    }

    public NoSuchQuestionException(String message) {
        super(message);
    }
}
