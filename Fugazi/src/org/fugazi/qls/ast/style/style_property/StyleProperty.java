package org.fugazi.qls.ast.style.style_property;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;

public abstract class StyleProperty<T> extends AbstractASTNode {
    
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
    
    public T getValue() {
        return this.value;
    }

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);
}
