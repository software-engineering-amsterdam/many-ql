package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.style.style_property.type.StringPropertyType;

public class Color extends StyleProperty {

    public static final String PROPERTY_NAME = "Color";

    public Color(int _lineNum, StringPropertyType _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public Color(StringPropertyType _value) {
        super(PROPERTY_NAME, _value);
    }
}
