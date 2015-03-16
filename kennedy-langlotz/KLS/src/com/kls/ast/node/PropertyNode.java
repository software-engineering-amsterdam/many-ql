package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.common.ast.Location;
import com.kls.ast.node.property.AProperty;

/**
 * Created by Timon on 03.03.2015.
 */
public class PropertyNode extends ANodeBase {
    private final AProperty property;

    public PropertyNode(AProperty property, Location location) {
        super(location);
        this.property = property;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public AProperty getProperty() {
        return property;
    }

}
