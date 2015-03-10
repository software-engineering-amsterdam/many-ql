package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;

import java.util.Map;

/**
 * Created by Timon on 03.03.2015.
 */
public class BooleanNode extends AValueNode<Boolean>{
    public BooleanNode(boolean value, String location) {
        super(value, location);
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
