package org.fugazi.qls.ast.style.style_property;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.style_property.type.StylePropertyType;

public abstract class StyleProperty extends AbstractASTNode {
    
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

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);
}
