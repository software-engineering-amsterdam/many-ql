package com.klq.logic.expression.operator.bool;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;

/**
 * Created by Timon on 23.02.2015.
 */
public class Or extends AExpression {

    public Or(AExpression left, AExpression right) {
        super(left, right, AExpression.OR);
    }

    @Override
    public AExpression evaluate() {
        AExpression left = this.left.evaluate();
        AExpression right = this.right.evaluate();
        if (left.getType() == right.getType() && left.getType() == AExpression.BOOLEAN)
            if (left == Boolean.TRUE || right == Boolean.TRUE)
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        return null;
    }
}
