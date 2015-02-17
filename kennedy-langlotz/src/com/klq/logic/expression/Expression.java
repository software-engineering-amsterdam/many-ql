package com.klq.logic.expression;

/**
 * Created by Timon on 17.02.2015.
 */
public abstract class Expression {
    protected String content;

    public Expression(String content) {
        this.content = content;
    }

    public abstract Expression evaluate();

    public abstract boolean isValidExpression();
}
