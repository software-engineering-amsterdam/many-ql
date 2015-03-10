package com.klq.ast.impl;

import com.common.Location;
import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.logic.question.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestionNode extends QuestionNode {
    private List<AExpression> children;

    public ComputedQuestionNode(String questionID, String questionType, String text, List<AExpression> children, Location location) {
        super(questionID, questionType, text, location);
        this.children = children;
    }

    public ComputedQuestionNode(String questionID, String questionType, String text, List<AExpression> children) {
        super(questionID, questionType, text);
        this.children = children;
    }

    public List<AExpression> getChildren() {
        return children;
    }

    @Override
    public void printSelf() {
        super.printSelf();
        System.out.printf("Child class: %s", children.getClass());
        System.out.println();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
