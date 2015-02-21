package com.klq.logic.expression;

/**
 * Created by Timon on 17.02.2015.
 */
public abstract class AExpression {
    protected final String content;

    public AExpression(String content) {
        this.content = content.replaceAll("\\s", "");
    }

    public abstract String evaluate();
}
