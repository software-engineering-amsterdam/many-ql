package com.klq.ast.impl.expr.bool;

import com.klq.ast.ANode;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;

/**
 * Created by Juriaan on 1-3-2015.
 */
public abstract class ABooleanNode extends ABinaryExprNode {

    public ABooleanNode(AExpression leftChild, AExpression rightChild, String location) {
        super(leftChild, rightChild, location);
    }
}
