package org.fugazi.qls.ast.style.style_property;

public class Font extends StyleProperty<String> {

    public static final String PROPERTY_NAME = "Font";

    public Font(int _lineNum, String _value) {
        super(_lineNum, PROPERTY_NAME, _value);
    }

    public Font(String _value) {
        super(PROPERTY_NAME, _value);
    }
}
