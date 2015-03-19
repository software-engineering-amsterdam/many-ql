package com.klq.ast.impl.value;


/**
 * Created by Timon on 03.03.2015.
 */
public abstract class Value<T> {
    private final T value;

    public Value(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public boolean isUndefined(){
        return false;
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
