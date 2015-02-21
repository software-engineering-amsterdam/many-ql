package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionnaireNode extends ANode {
    @Override
    public void accept(IVisitor visitor) {
        for(ANode child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }
}
