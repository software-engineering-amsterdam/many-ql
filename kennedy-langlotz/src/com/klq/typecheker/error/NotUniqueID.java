package com.klq.typecheker.error;

import com.klq.ast.impl.QuestionNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class NotUniqueID extends AError{
    public NotUniqueID(QuestionNode node) {
        super(1, true, String.format("The question identifier: \"%s\" is not unique", node.getQuestionID()), node.getLoc());
    }

}
