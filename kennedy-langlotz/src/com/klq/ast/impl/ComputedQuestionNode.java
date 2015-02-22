package com.klq.ast.impl;

import com.klq.ast.*;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestionNode extends QuestionNode {
    private ANode child;

    public ComputedQuestionNode(String questionID, String questionType, String text, ANode child) {
        super(questionID, questionType, text);
        this.child = child;
    }

    @Override
    public void printSelf() {
        super.printSelf();
        System.out.printf("Child class: %s", child.getClass());
        System.out.println();
    }

    @Override
    public void accept(IVisitor visitor) {
        child.accept(visitor);
        visitor.visit(this);
    }

}
