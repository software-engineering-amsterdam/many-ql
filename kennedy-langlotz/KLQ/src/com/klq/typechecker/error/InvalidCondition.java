package com.klq.typechecker.error;

import com.klq.ast.impl.ConditionalNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class InvalidCondition extends AError{
    public InvalidCondition(ConditionalNode node) {
        super(2, true, "The expression of the condition does not return a boolean value", node.getLocation());
    }
}
