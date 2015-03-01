package com.klq.typecheker.error;

import com.klq.ast.impl.ConditionalNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class NotAValidCondition extends AError{
    public NotAValidCondition(ConditionalNode node) {
        super(1, true, "The expression of the condition does not return a boolean value", node.getLoc());
    }
}
