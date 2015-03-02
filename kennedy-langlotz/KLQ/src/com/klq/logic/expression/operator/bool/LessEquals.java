package com.klq.logic.expression.operator.bool;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.Boolean;

/**
 * Created by Timon on 23.02.2015.
 */
public class LessEquals extends AExpression {

    public LessEquals(AExpression left, AExpression right) {
        super(left, right, AExpression.LESS_EQUALS);
    }

    @Override
    public AExpression evaluate() {
        AExpression left = this.left.evaluate();
        AExpression right = this.right.evaluate();
        if (left.getType() == right.getType()) {
            int comp = left.compareTo(right);
            if (comp == AExpression.UNCOMPARABLE)
                return null;
            if (comp <= 0)
                return Boolean.getTrue();
            else if (comp > 0)
                return Boolean.getFalse();
        }
        return new LessEquals(left, right);
    }
}
