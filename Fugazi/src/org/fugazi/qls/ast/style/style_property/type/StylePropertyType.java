package org.fugazi.qls.ast.style.style_property.type;

import org.fugazi.qls.ast.AbstractASTQLSNode;

public abstract class StylePropertyType<T> extends AbstractASTQLSNode {

    private final T value;

    public StylePropertyType(int _lineNum, T _value) {
        super(_lineNum);
        this.value = _value;
    }

    public StylePropertyType(T _value) {
        this.value = _value;
    }

    public T getValue() {
        return this.value;
    }
}
