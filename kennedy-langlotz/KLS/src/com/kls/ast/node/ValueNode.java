package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

/**
 * Created by Timon on 03.03.2015.
 */
public class ValueNode extends ANode {
    private final Value value;

    public ValueNode(Value value, Location location) {
        super(location);
        this.value = value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Value getValue() {
        return value;
    }
}
