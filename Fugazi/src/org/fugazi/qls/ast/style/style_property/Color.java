package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.IQLSASTVisitor;

public class Color extends StyleProperty<Integer> {

    public static final String PROPERTY_NAME = "color";

    public Color(int _value) {
        super(PROPERTY_NAME, _value);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitColorProperty(this);
    }
}
