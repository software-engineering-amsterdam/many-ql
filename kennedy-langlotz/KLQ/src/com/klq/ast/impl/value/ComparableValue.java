package com.klq.ast.impl.value;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class ComparableValue<T extends Comparable<T>> extends Value<T> implements Comparable<Value<T>> {

    public ComparableValue(T value) {
        super(value);
    }

    @Override
    public int compareTo(Value<T> o) {
        return getValue().compareTo(o.getValue());
    }
}
