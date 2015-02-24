package com.klq.logic.expression.operator.math;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Number;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Timon on 23.02.2015.
 */
public class Division extends AExpression {
    private final int PRECISION = 100;

    public Division(AExpression left, AExpression right) {
        super(left, right, AExpression.DIV);
    }

    @Override
    public AExpression evaluate() {
        AExpression left = this.left.evaluate();
        AExpression right = this.right.evaluate();
        if (left.getType() == AExpression.NUMBER && right.getType() == AExpression.NUMBER){
            BigDecimal l = new BigDecimal(left.getContent());
            BigDecimal r = new BigDecimal(right.getContent());
            return new Number(l.divide(r, new MathContext(PRECISION)).toString());
        }
        return null;
    }
}
