package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

/**
 * Created by Juriaan on 21-2-2015.
 */
public abstract class ABinaryExprNode extends ANode {
    private ANode leftChild;
    private ANode rightChild;

    public ABinaryExprNode(ANode leftChild, ANode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public void accept(IVisitor visitor) {
        this.leftChild.accept(visitor);
        this.rightChild.accept(visitor);
        visitor.visit(this);
    }
}
