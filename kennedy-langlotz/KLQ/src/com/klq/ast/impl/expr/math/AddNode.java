package com.klq.ast.impl.expr.math;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.ast.impl.expr.literal.NumberNode;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.NumberValue;
import com.klq.logic.value.Value;

import java.util.Map;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class AddNode extends ABinaryExprNode {

    public AddNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierValue, Value> variables) {
        NumberValue left = (NumberValue) (getLeftChild().evaluate(variables));
        NumberValue right = (NumberValue) (getRightChild().evaluate(variables));

        return new NumberValue(left.getValue().add(right.getValue()));
    }
}
