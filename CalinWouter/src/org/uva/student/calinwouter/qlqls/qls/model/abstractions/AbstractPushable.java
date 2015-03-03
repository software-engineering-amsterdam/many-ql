package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.model.interfaces.IModel;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;

public abstract class AbstractPushable<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public HashMap.SimpleEntry<Object, Object> getSimpleEntry() {
        throw new RuntimeException("Value is not of type HashMap.SimpleEntry, but of type: " + value.getClass() + ".");
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

    public HashMap<String, Object> getHashMap() {
        throw new RuntimeException("Value is not of type HashMap, but of type: " + value.getClass() + ".");
    }

    public void apply(IModel model) {
        throw new RuntimeException(new OperationNotSupportedException());
    }

    public AbstractPushable(T value) {
        this.value = value;
    }

}
