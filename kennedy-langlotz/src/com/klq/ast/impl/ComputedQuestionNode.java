package com.klq.ast.impl;

import com.klq.ast.*;

import java.util.ArrayList;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestionNode extends QuestionNode {
    private ArrayList<ANode> children;

    public ComputedQuestionNode(String questionID, String questionType, String text, ArrayList<ANode> children, String location) {
        super(questionID, questionType, text, location);
        this.children = children;
    }

    public ArrayList<ANode> getChildren() {
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
