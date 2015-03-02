package com.klq.ast.impl;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

import java.util.ArrayList;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionnaireNode extends ANode {
    private ArrayList<ANode> children;

    public QuestionnaireNode(String location) {
        super(location);
        this.children = new ArrayList<ANode>();
    }

    public ArrayList<ANode> getChildren() {
        return children;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
