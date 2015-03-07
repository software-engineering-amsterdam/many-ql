package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;

import java.util.Map;

/**
 * Created by juriaan on 10-2-15.
 */
public class StringNode extends AValueNode<String> {

    public StringNode(String string, String location) {
        super(string, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        return this;
    }
}
