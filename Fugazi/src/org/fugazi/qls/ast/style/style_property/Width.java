package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.style.style_property.type.IntPropertyType;

public class Width extends StyleProperty {

    public static final String PROPERTY_NAME = "Width";

    public Width(int _lineNum, IntPropertyType _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public Width(IntPropertyType _value) {
        super(PROPERTY_NAME, _value);
    }
}
