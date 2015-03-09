package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.common.Location;
import com.kls.ast.node.value.AValue;

/**
 * Created by Timon on 03.03.2015.
 */
public class ValueNode extends ANodeBase {
    private final AValue value;

    public ValueNode(AValue value, Location location) {
        super(location);
        this.value = value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public AValue getValue() {
        return value;
    }
}
