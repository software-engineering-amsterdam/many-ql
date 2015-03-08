package com.klq.ast.impl.expr.bool;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.AValueNode;
import com.klq.ast.impl.expr.literal.BooleanNode;
import com.klq.ast.impl.expr.literal.NumberNode;

import java.util.Map;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class GreaterEqualsNode extends ABooleanNode {

    public GreaterEqualsNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    //TODO Now only works for numbers, make it work for other primitives?
    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        NumberNode left = (NumberNode) (getLeftChild().evaluate(variableTable));
        NumberNode right =(NumberNode) (getRightChild().evaluate(variableTable));

        return new BooleanNode(left.getValue().compareTo(right.getValue()) >= 0, "");
    }
}
