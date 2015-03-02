package com.klq.logic.expression.terminal;

import com.klq.logic.expression.AExpression;

/**
 * Created by Timon on 23.02.2015.
 */
public class String extends AExpression {
    private final java.lang.String content;

    public String(java.lang.String content) {
        super(null, null, AExpression.STRING);
        this.content = content;
    }

    @Override
    public AExpression evaluate() {
        return this;
    }

    @Override
    public java.lang.String getContent() {
        return content;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof String)
            return content.compareTo(((String)o).getContent());
        return AExpression.UNCOMPARABLE;
    }
}
