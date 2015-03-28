package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.IQLSASTVisitor;

public class Font extends StyleProperty<String> {

    public static final String PROPERTY_NAME = "font";

    public Font(String _value) {
        super(PROPERTY_NAME, _value);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitFontProperty(this);
    }
}
