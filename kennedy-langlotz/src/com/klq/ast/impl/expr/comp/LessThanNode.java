package com.klq.ast.impl.expr.comp;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.ABinaryExprNode;

/**
 * Created by Juriaan on 22-2-2015.
 */
public class LessThanNode extends ABinaryExprNode {

    public LessThanNode(ANode leftChild, ANode rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public void accept(IVisitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
}
