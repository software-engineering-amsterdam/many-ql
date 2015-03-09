package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

/**
 * Created by Timon on 03.03.2015.
 */
public class PropertyNode extends ANodeBase {
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
        FONT_FAMILY("font-family"), FONT_STYLE("font-style"), FONT_SIZE("font-size"),
        FONT_COLOR("font-color"), BACKGROUND_COLOR("background-color"), WIDGET("widget");
        private final String property;

        private Property(String property){
            this.property = property;
        }

        public static Property getEnum(String value) {
            for(Property v : values())
                if(v.property.equals(value)) return v;
            throw new IllegalArgumentException();
        }
    }
}
