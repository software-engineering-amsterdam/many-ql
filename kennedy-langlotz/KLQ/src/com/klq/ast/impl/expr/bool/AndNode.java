package com.klq.ast.impl.expr.bool;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.BooleanNode;
import com.klq.ast.impl.expr.literal.IdentifierNode;
import com.klq.logic.value.BooleanValue;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.Value;

import java.util.Map;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class AndNode extends ABooleanNode {

    public AndNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value evaluate(Map<IdentifierValue, Value> variables) {
        BooleanValue left = (BooleanValue)(getLeftChild().evaluate(variables));
        BooleanValue right =(BooleanValue)(getRightChild().evaluate(variables));

        return new BooleanValue(left.getValue() && right.getValue());
    }
}
