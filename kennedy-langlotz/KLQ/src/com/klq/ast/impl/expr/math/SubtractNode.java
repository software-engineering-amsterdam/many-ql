package com.klq.ast.impl.expr.math;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.NumberValue;
import com.klq.ast.impl.expr.value.Value;

import java.util.Map;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class SubtractNode extends ABinaryExprNode {

    public SubtractNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        NumberValue left = (NumberValue) (getLeftChild().evaluate(variables));
        NumberValue right = (NumberValue) (getRightChild().evaluate(variables));

        return new NumberValue(left.getValue().subtract(right.getValue()));
    }
}
