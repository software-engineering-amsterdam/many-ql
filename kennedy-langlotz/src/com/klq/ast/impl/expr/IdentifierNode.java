package com.klq.ast.impl.expr;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.QuestionNode;

/**
 * Created by juriaan on 23-2-15.
 */
public class IdentifierNode extends ANode {
    String identifier;

    public IdentifierNode(String identifier) {

        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }}
