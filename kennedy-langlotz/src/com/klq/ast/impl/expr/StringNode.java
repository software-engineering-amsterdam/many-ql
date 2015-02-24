package com.klq.ast.impl.expr;

import com.klq.ast.ANode;
import com.klq.ast.IVisitor;

/**
 * Created by juriaan on 10-2-15.
 */
public class StringNode extends ANode {
    private String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getString() {
        return string;
    }
}
