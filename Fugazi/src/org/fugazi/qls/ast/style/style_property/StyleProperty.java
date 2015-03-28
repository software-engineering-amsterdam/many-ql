package org.fugazi.qls.ast.style.style_property;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;

public abstract class StyleProperty<T> extends AbstractASTNode {
    
    protected final String name;
    protected final T value;

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

    @Override
    public boolean equals(Object o){
        if (o == null) {
            return false;
        }

        if (!(o instanceof StyleProperty)) {
            return false;
        }

        StyleProperty other = (StyleProperty) o;
        return this.name == other.name;
    }

    @Override
    public int hashCode() {
        return (this.name.hashCode());
    }
}
