package org.fugazi.qls.ast.style.style_property;

import org.fugazi.qls.ast.AbstractASTQLSNode;

public abstract class StyleProperty<T> extends AbstractASTQLSNode {
    
    protected final String name;
    protected final T value;

    public StyleProperty(int _lineNum, String _name, T _value) {
        this.name = _name;
        this.value = _value;
    }

    public StyleProperty(String _name, T _value) {
        this.name = _name;
        this.value = _value;
    }

    public String getName() {
        return this.name;        
    }    
    
    //todo: think of - Not generic but a StyleValue Class.
    public T getValue() {
        return this.value;
    }
}
