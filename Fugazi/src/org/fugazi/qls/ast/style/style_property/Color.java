package org.fugazi.qls.ast.style.style_property;

public class Color extends StyleProperty<String> {

    public static final String PROPERTY_NAME = "Color";

    public Color(int _lineNum, String _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public Color(String _value) {
        super(PROPERTY_NAME, _value);
    }
}
