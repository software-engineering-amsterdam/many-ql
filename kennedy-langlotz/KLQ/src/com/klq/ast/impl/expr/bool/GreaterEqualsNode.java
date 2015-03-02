package com.klq.ast.impl.expr.bool;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class GreaterEqualsNode extends ABooleanNode {

    public GreaterEqualsNode(ANode leftChild, ANode rightChild, String location) {
        super(leftChild, rightChild, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
