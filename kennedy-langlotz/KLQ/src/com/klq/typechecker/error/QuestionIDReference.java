package com.klq.typechecker.error;

import com.klq.ast.impl.expr.IdentifierNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class QuestionIDReference extends AError{
    public QuestionIDReference(IdentifierNode node) {
        super(3, true, String.format("This identifier (%s) refers to a question that does not exist", node.getIdentifier()), node.getLocation());
    }
}
