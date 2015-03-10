package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.style.style_property.type.StylePropertyType;

public abstract class StyleProperty extends AbstractASTQLSNode {
    
    protected final String name;
    protected final StylePropertyType value;

    public StyleProperty(int _lineNum, String _name, StylePropertyType _value) {
        this.name = _name;
        this.value = _value;
    }

    public StyleProperty(String _name, StylePropertyType _value) {
        this.name = _name;
        this.value = _value;
    }

    public String getName() {
        return this.name;        
    }    
    
    public StylePropertyType getValue() {
        return this.value;
    }
}
