package com.klq.ast.impl;

import com.klq.ast.*;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestionNode extends QuestionNode {
    private ANode child;

    public ComputedQuestionNode(String questionID, String questionType, String text, ANode child, String location) {
        super(questionID, questionType, text, location);
        this.child = child;
    }

    public ANode getChild() {
        return child;
    }

    @Override
    public void printSelf() {
        super.printSelf();
        System.out.printf("Child class: %s", child.getClass());
        System.out.println();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
