package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

/**
 * Created by Timon on 03.03.2015.
 */
public class PropertyNode extends ANode {
    private final Property property;

    public PropertyNode(Property property, Location location) {
        super(location);
        this.property = property;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Property getProperty() {
        return property;
    }

    public enum Property {
        FONT_FAMILY, FONT_STYLE, FONT_SIZE, FONT_COLOR, BACKGROUND_COLOR, WIDGET;
    }
}
