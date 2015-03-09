package com.klq.typecheker.error;

import com.klq.ast.impl.QuestionNode;
import com.klq.logic.question.Type;

/**
 * Created by juriaan on 2-3-15.
 */
public class TypeMismatch extends AError {
    public TypeMismatch(QuestionNode node, Type child) {
        super(4, true, String.format("This question is of the type: %s, however the computed answer is of the type: %s", node.getQuestionType(), child), node.getLocation());
    }
}
