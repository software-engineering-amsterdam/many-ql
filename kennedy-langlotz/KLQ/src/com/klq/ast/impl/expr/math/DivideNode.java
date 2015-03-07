package com.klq.ast.impl.expr.math;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.literal.AValueNode;
import com.klq.ast.impl.expr.literal.NumberNode;

import java.math.MathContext;
import java.util.Map;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class DivideNode extends ABinaryExprNode {
    private final MathContext MATH_CONTEXT = new MathContext(100);

    public DivideNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        NumberNode left = (NumberNode)(getLeftChild().evaluate(variableTable));
        NumberNode right = (NumberNode) (getRightChild().evaluate(variableTable));

        return new NumberNode(left.getValue().divide(right.getValue()), "");
    }
}
