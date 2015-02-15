package org.uva.student.calinwouter.qlqls.qls.types;

import org.uva.student.calinwouter.qlqls.ql.interpreter.components.TypeDescriptor;

import java.util.AbstractMap;
import java.util.HashMap;

public abstract class AbstractPushable<T> {
    private T value;

    public T getValue() { return value; }

    public HashMap<Object, Object> getHashMap() {
        throw new RuntimeException("Value is not of type HashMap, but of type: " + value.getClass() + ".");
    }

    public HashMap.SimpleEntry<Object, Object> getSimpleEntry() {
        throw new RuntimeException("Value is not of type HashMap.SimpleEntry, but of type: " + value.getClass() + ".");
    }

    public Object[] getObjectArray() {
        throw new RuntimeException("Value is not of type Object[], but of type: " + value.getClass() + ".");
    }

    public TypeDescriptor<?> getTypeDescriptor() {
        throw new RuntimeException("Value is not of type TypeDescriptor, but of type: " + value.getClass() + ".");
    }

    public String getString() {
        throw new RuntimeException("Value is not of type String, but of type: " + value.getClass() + ".");
    }

    public Integer getInteger() {
        throw new RuntimeException("Value is not of type Integer, but of type: " + value.getClass() + ".");
    }

    public AbstractPushable(T value) {
        this.value = value;
    }

}
