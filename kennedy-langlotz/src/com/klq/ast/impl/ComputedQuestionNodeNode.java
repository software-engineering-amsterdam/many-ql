package com.klq.ast.impl;

import com.klq.ast.*;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestionNodeNode extends QuestionNode {

    public ComputedQuestionNodeNode(String questionID, String questionType, String text) {
        super(questionID, questionType, text);
    }

    @Override
    public void accept(IVisitor visitor) {
        for(ANode child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }

}
