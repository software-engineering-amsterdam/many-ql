package com.klq.logic.expression.terminal;

import com.klq.logic.expression.AExpression;

import java.lang.String;
import java.math.BigDecimal;

/**
 * Created by Timon on 23.02.2015.
 */
public class Number extends AExpression {
    private final String content;

    public Number(String content) {
        super(null, null, AExpression.NUMBER);
        this.content = content;
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
        if (o instanceof Number){
            BigDecimal b1 = new BigDecimal(content);
            BigDecimal b2 = new BigDecimal(((Number)o).getContent());
            return b1.compareTo(b2);
        }
        return AExpression.UNCOMPARABLE;
    }
}
