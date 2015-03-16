package com.kls.ast.node.value;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class AValue<T> {
    private T value;
    public Type type;

    public AValue(T value, Type type){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        COLOR, FONT_SIZE, FONT_STYLE, WIDGET, STRING;
    }
}
