package com.klq.ast.impl.expr.math;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.value.NumberValue;
import com.klq.ast.impl.value.UndefinedValue;
import com.klq.ast.impl.value.Value;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class MultiplyNode extends AMathNode {

    public MultiplyNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public MultiplyNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierNode, Value> variables) {
        Value left = (getLeftChild().evaluate(variables));
        Value right = (getRightChild().evaluate(variables));

        if(anyUndefined(left, right))
        {
            return new UndefinedValue();
        }
        else {
            BigDecimal leftValue = (BigDecimal) left.getValue();
            BigDecimal rightValue = (BigDecimal) right.getValue();
            return new NumberValue(leftValue.multiply(rightValue));
        }
    }
}
