package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.style_property.type.StringPropertyType;

public class Font extends StyleProperty {

    public static final String PROPERTY_NAME = "Font";

    public Font(int _lineNum, StringPropertyType _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public Font(StringPropertyType _value) {
        super(PROPERTY_NAME, _value);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitFontProperty(this);
    }
}
