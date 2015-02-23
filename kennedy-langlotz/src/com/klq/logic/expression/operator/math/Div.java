package com.klq.logic.expression.operator.math;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Number;

import java.math.BigDecimal;

/**
 * Created by Timon on 23.02.2015.
 */
public class Div extends AExpression {

    public Div(AExpression left, AExpression right) {
        super(left, right, AExpression.DIV);
    }

    @Override
    public AExpression evaluate() {
        AExpression left = this.left.evaluate();
        AExpression right = this.right.evaluate();
        if (left.getType() == AExpression.NUMBER && right.getType() == AExpression.NUMBER){
            BigDecimal l = new BigDecimal(left.getContent());
            BigDecimal r = new BigDecimal(right.getContent());
            return new Number(l.divide(r).toString());
        }
        return null;
    }
}
