package com.klq.typecheker.error;

import com.common.Location;
import com.klq.ast.impl.QuestionNode;
import com.klq.ast.impl.expr.ABinaryExprNode;
import com.klq.logic.question.Type;

import java.util.Set;

/**
 * Created by Juriaan on 1-3-2015.
 */
public class CyclicDependency extends AError{
    public CyclicDependency(QuestionNode node) {
        super(7, true, String.format("There is a cyclic dependency at the following question: %s", node.getQuestionID()), node.getLocation());
    }
}
