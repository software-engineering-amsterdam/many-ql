package com.klq.typechecker.error;

import com.klq.ast.impl.QuestionNode;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class CyclicDependency extends AError{
    public CyclicDependency(QuestionNode node) {
        super(7, true, String.format("There is a cyclic dependency at the following question: %s", node.getQuestionID()), node.getLocation());
    }
}
