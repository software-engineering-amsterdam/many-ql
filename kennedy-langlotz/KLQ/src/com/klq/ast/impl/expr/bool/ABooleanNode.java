package com.klq.ast.impl.expr.bool;

import com.klq.ast.Location;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;

/**
 * Created by Juriaan on 1-3-2015.
 */
public abstract class ABooleanNode extends ABinaryExprNode {

    public ABooleanNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public ABooleanNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }
}
