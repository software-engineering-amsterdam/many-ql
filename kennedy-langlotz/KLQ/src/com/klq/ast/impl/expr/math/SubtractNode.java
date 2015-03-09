package com.klq.ast.impl.expr.math;

import com.common.Location;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.NumberValue;
import com.klq.ast.impl.expr.value.UndefinedValue;
import com.klq.ast.impl.expr.value.Value;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class SubtractNode extends AMathNode {

    public SubtractNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public SubtractNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        Value left = (getLeftChild().evaluate(variables));
        Value right = (getRightChild().evaluate(variables));

        if(anyUndefined(left, right))
        {
            return new UndefinedValue();
        }
        else {
            BigDecimal leftValue = (BigDecimal) left.getValue();
            BigDecimal rightValue = (BigDecimal) right.getValue();
            return new NumberValue(leftValue.subtract(rightValue));
        }
    }
}
