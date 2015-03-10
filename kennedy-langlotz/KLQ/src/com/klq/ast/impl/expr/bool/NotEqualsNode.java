package com.klq.ast.impl.expr.bool;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.AValueNode;
import com.klq.ast.impl.expr.literal.BooleanNode;

import java.util.Map;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class NotEqualsNode extends ABooleanNode {

    public NotEqualsNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        AValueNode left = (getLeftChild().evaluate(variableTable));
        AValueNode right =(getRightChild().evaluate(variableTable));

        return new BooleanNode(!left.equals(right), "");
    }
}
