package com.klq.ast.impl.expr.bool;

import com.klq.ast.ANode;
import com.klq.ast.impl.expr.ABinaryExprNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public abstract class ABooleanNode extends ABinaryExprNode {
    public ABooleanNode(ANode leftChild, ANode rightChild, String location) {
        super(leftChild, rightChild, location);
    }
}
