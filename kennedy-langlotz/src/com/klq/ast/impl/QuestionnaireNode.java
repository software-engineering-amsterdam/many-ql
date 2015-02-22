package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.util.ArrayList;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionnaireNode extends ANode {
    private ArrayList<ANode> children;

    public QuestionnaireNode() {
        this.children = new ArrayList<ANode>();
    }

    public ArrayList<ANode> getChildren() {
        return children;
    }

    @Override
    public void accept(IVisitor visitor) {
        for(ANode child : this.getChildren()){
            child.accept(visitor);
        }
        visitor.visit(this);
    }
}
