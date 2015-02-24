package com.klq.logic.expression.operator.math;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Number;

import java.math.BigDecimal;

/**
 * Created by Timon on 23.02.2015.
 */
public class Multiplication extends AExpression {

    public Multiplication(AExpression left, AExpression right) {
        super(left, right, AExpression.MUL);
    }

    @Override
    public AExpression evaluate() {
        AExpression left = this.left.evaluate();
        AExpression right = this.right.evaluate();
        if (left.getType() == AExpression.NUMBER && right.getType() == AExpression.NUMBER){
            BigDecimal l = new BigDecimal(left.getContent());
            BigDecimal r = new BigDecimal(right.getContent());
            return new Number(l.multiply(r).toString());
        }
        return null;
    }
}
