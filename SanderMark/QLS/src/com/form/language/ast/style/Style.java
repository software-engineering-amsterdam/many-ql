package com.form.language.ast.style;

import com.form.language.ast.ASTNode;

public abstract class Style<T> implements ASTNode {
   
	protected final String name;
    protected final T value;
    
    public Style(String _name, T _value) {
        this.name = _name;
        this.value = _value;
    }

}
