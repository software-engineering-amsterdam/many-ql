package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

/**
 * Created by Timon on 03.03.2015.
 */
public class DeclarationNode extends ANode {
    private final PropertyNode propertyNode;
    private final ValueNode valueNode;

    public DeclarationNode(PropertyNode propertyNode, ValueNode valueNode, Location location) {
        super(location);
        this.propertyNode = propertyNode;
        this.valueNode = valueNode;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public PropertyNode getProperty() {
        return propertyNode;
    }

    public ValueNode getValue() {
        return valueNode;
    }
}
