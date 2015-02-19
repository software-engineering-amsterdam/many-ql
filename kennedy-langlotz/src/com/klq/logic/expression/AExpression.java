package com.klq.logic.expression;

/**
 * Created by Timon on 17.02.2015.
 */
public abstract class AExpression {
    protected String content;

    public AExpression(String content) {
        this.content = content;
    }

    public abstract AExpression evaluate();

    public abstract boolean isValidExpression();
}
