package com.klq.logic.expression.operator.bool;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;

/**
 * Created by Timon on 23.02.2015.
 */
public class And extends AExpression {

    public And(AExpression left, AExpression right) {
        super(left, right, AExpression.AND);
    }

    @Override
    public AExpression evaluate() {
        AExpression left = this.left.evaluate();
        AExpression right = this.right.evaluate();
        if (left.getType() == right.getType() && left.getType() == AExpression.BOOLEAN)
            if (left == Boolean.getTrue() && right == Boolean.getTrue())
                return Boolean.getTrue();
            else
                return Boolean.getFalse();
        return new And(left, right);
    }
}
