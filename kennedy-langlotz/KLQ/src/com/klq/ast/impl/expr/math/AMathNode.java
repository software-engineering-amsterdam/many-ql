package com.klq.ast.impl.expr.math;

import com.common.ast.Location;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.ast.impl.expr.AExpression;

/**
 * Created by juriaan on 9-3-15.
 */
public abstract class AMathNode extends ABinaryExprNode{
    public AMathNode(AExpression leftChild, AExpression rightChild, Location location) {
        super(leftChild, rightChild, location);
    }

    public AMathNode(AExpression leftChild, AExpression rightChild) {
        super(leftChild, rightChild);
    }
}
