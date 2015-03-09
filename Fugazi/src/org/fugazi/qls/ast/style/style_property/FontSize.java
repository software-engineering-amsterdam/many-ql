package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.IQLSASTVisitor;

public class FontSize extends StyleProperty<Integer> {

    public static final String PROPERTY_NAME = "FontSize";

    public FontSize(int _lineNum, Integer _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public FontSize(Integer _value) {
        super(PROPERTY_NAME, _value);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitFontSizeProperty(this);
    }
}
