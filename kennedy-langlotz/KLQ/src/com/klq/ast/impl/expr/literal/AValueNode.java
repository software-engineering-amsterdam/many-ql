package com.klq.ast.impl.expr.literal;

import com.klq.ast.impl.expr.AExpression;


/**
 * Created by Juriaan on 7-3-2015.
 */
public abstract class AValueNode<T> extends AExpression {
    private T value;

    public AValueNode(T value, String location) {
        super(null, null, location);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    //TODO don't we need hashcode as well?
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AValueNode)){
            return false;
        }
        if (!(obj.getClass().equals(this.getClass()))){
            return false;
        }
        return value.equals(((AValueNode<?>) obj).getValue());
    }
}
