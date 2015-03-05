package org.fugazi.qls.ast.style.style_property;

public class Width extends StyleProperty<Integer> {

    public static final String PROPERTY_NAME = "Width";

    public Width(int _lineNum, Integer _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public Width(Integer _value) {
        super(PROPERTY_NAME, _value);
    }
}
