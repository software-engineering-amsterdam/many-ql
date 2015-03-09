package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.style_property.type.IntPropertyType;

public class FontSize extends StyleProperty {

    public static final String PROPERTY_NAME = "FontSize";

    public FontSize(int _lineNum, IntPropertyType _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public FontSize(IntPropertyType _value) {
        super(PROPERTY_NAME, _value);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitFontSizeProperty(this);
    }
}
