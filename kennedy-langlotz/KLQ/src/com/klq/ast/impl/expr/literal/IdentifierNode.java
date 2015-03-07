package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;

import java.util.Map;

/**
 * Created by juriaan on 23-2-15.
 */
public class IdentifierNode extends AValueNode<String> {
    public IdentifierNode(String identifier, String location) {
        super(identifier, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        return variableTable.get(getValue());
    }
}
