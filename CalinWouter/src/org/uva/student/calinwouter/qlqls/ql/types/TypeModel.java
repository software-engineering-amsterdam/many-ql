package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.exceptions.CastException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;

/**
 * TypeModel with basic operators. Implementations should support value=null for the typechecker, which basically
 * throws an error in case of an exception or returns the TypeModel with value=null.
 * @param <T> the type of the value stored internally.
 */
public abstract class TypeModel<T> {
    private final T value;

    public TypeModel<?> and(TypeModel<?> typeModel) {
        throw new CastException("and", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> or(TypeModel<?> typeModel) {
        throw new CastException("or", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> add(TypeModel<?> typeModel) {
        throw new CastException("add", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> sub(TypeModel<?> typeModel) {
        throw new CastException("sub", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> mul(TypeModel<?> typeModel) {
        throw new CastException("mul", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> div(TypeModel<?> typeModel) {
        throw new CastException("div", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> mod(TypeModel<?> typeModel) {
        throw new CastException("mod", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> not() {
        throw new CastException("not", getTypeModelClass());
    }

    public TypeModel<?> eq(TypeModel<?> typeModel) {
        if (getValue() == null)
            return new TBool(null);
        return new TBool(getValue().equals(typeModel.getValue()));
    }

    public TypeModel<?> neq(TypeModel<?> typeModel) {
        if (getValue() == null)
            return new TBool(null);
        return new TBool(!getValue().equals(typeModel.getValue()));
    }

    public TypeModel<?> lt(TypeModel<?> typeModel) {
        throw new CastException("lt", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> gt(TypeModel<?> typeModel) {
        throw new CastException("gt", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> lte(TypeModel<?> typeModel) {
        throw new CastException("lte", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public TypeModel<?> gte(TypeModel<?> typeModel) {
        throw new CastException("gte", getTypeModelClass(), typeModel.getTypeModelClass());
    }

    public abstract Class<T> getTypeModelClass();

    public abstract void apply(TypeCallback typeCallback);

    public T getValue() {
        return value;
    }

    public TypeModel(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TypeModel && ((TypeModel) obj).getValue().equals(getValue());
    }

    @Override
    public String toString() {
        return "" + getValue();
    }
}
