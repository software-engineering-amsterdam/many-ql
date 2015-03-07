package com.klq.ast.impl.expr.bool;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.logic.value.BooleanValue;
import com.klq.logic.value.ComparableValue;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.Value;

import java.util.Map;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class GreaterThanNode extends ABooleanNode {

    public GreaterThanNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierValue, Value> variables) {
        ComparableValue left = (ComparableValue)(getLeftChild().evaluate(variables));
        ComparableValue right = (ComparableValue)(getRightChild().evaluate(variables));

        return new BooleanValue(left.compareTo(right) > 0);
    }
}
