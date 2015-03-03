package com.klq.logic.value;

import com.klq.logic.IKLQItem;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class Value<T> implements IKLQItem {
    private final T value;

    public Value(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
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
    public String toString() {
        return getValue().toString();
    }
}
