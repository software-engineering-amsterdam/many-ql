package com.klq.ast.impl.expr.value;


/**
 * Created by Timon on 03.03.2015.
 */
public abstract class Value<T> {
    private final T value;
    //TODO WTF?
    private boolean undefined;

    public Value(T value){
        this.value = value;
        this.undefined = false;
    }

    public Value(T value, boolean undefined){
        this.value = value;
        this.undefined = undefined;
    }

    public T getValue(){
        return value;
    }

    public boolean isUndefined(){
        return undefined;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Value)){
            return false;
        }
        if (!(obj.getClass().equals(this.getClass()))){
            return false;
        }
        return value.equals(((Value<?>) obj).getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}
