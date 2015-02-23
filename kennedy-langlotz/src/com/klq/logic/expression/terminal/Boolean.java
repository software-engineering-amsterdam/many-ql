package com.klq.logic.expression.terminal;

import com.klq.logic.expression.AExpression;

import java.lang.*;
import java.lang.String;

/**
 * Created by Timon on 23.02.2015.
 */
public class Boolean extends AExpression {
    public final static Boolean TRUE = new Boolean(true);
    public final static Boolean FALSE = new Boolean(false);

    private final String content;

    private Boolean(boolean isTrue) {
        super(null, null, AExpression.BOOLEAN);
        if (isTrue)
            content = "true";
        else
            content = "false";
    }

    @Override
    public AExpression evaluate() {
        return this;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof  Boolean){
            return content.compareTo(((Boolean)o).getContent());
        }
        return AExpression.UNCOMPARABLE;
    }
}
