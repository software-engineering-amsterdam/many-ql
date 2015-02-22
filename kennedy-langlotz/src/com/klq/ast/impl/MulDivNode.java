package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.util.ArrayList;

/**
 * Created by Juriaan on 21-2-2015.
 */
public class MulDivNode extends ABinaryExprNode {

    public MulDivNode(ANode leftChild, ANode rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public void accept(IVisitor visitor) {
        super.accept(visitor);
        visitor.visit(this);
    }
}
