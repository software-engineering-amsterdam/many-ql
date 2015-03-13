package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.exceptions.CastException;
import org.uva.student.calinwouter.qlqls.ql.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;

/**
 * Value with basic operators. Implementations should support value=null for the typechecker, which basically
 * throws an error in case of an exception or returns the Value with value=null.
 *
 * @param <T> the type of the value stored internally.
 */
public abstract class Value<T> {
    private final T value;
    private TypeDescriptor<?> typeDescriptor;

    public Value<?> and(Value<?> value) {
        throw new CastException("and", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> or(Value<?> value) {
        throw new CastException("or", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> add(Value<?> value) {
        throw new CastException("add", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> sub(Value<?> value) {
        throw new CastException("sub", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> mul(Value<?> value) {
        throw new CastException("mul", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> div(Value<?> value) {
        throw new CastException("div", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> mod(Value<?> value) {
        throw new CastException("mod", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> not() {
        throw new CastException("not", getTypeModelClass());
    }

    public Value<?> eq(Value<?> value) {
        if (getValue() == null)
            return new BoolValue(null);
        return new BoolValue(getValue().equals(value.getValue()));
    }

    public Value<?> neq(Value<?> value) {
        if (getValue() == null)
            return new BoolValue(null);
        return new BoolValue(!getValue().equals(value.getValue()));
    }

    public Value<?> lt(Value<?> value) {
        throw new CastException("lt", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> gt(Value<?> value) {
        throw new CastException("gt", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> lte(Value<?> value) {
        throw new CastException("lte", getTypeModelClass(), value.getTypeModelClass());
    }

    public Value<?> gte(Value<?> value) {
        throw new CastException("gte", getTypeModelClass(), value.getTypeModelClass());
    }

    public abstract Class<T> getTypeModelClass();

    public abstract void apply(TypeCallback typeCallback);

    public T getValue() {
        return value;
    }

    public Value(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Value && ((Value) obj).getValue().equals(getValue());
    }

    @Override
    public String toString() {
        return "" + getValue();
    }

    public abstract TypeDescriptor<?> getTypeDescriptor();
}
