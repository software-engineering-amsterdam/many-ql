package org.fugazi.qls.ast.style.style_property.type;

public class StringPropertyType extends StylePropertyType<String> {

    public StringPropertyType(int _lineNum, String _value) {
        super(_lineNum, _value);
    }

    public StringPropertyType(String _value) {
        super(_value);
    }
}