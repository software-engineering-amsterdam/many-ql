package com.common.typechecker.error;

import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.logic.question.Type;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class Incomparable extends AError{
    public Incomparable(ABinaryExprNode node, String operator, Type leftChild, Type rightChild) {
        super(5, true, String.format("The operands of the \"%s\" operator are not of the same type. The left operand is a %s. The right operand is a %s", operator, leftChild, rightChild), node.getLocation());
    }

}
