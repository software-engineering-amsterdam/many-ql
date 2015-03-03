package org.fugazi.qls.ast.style.style_property;

public class Color extends StyleProperty<String> {

    public static final String PROPERTY_NAME = "Color";
    
    public Color(String _value) {
        super(PROPERTY_NAME, _value);
    }
}
