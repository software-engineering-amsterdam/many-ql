package org.uva.student.calinwouter.ql.interpreter.model.types;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;

public abstract class TypeModel<T> {

    private final T value;

    private String createTypeCheckException(String method, Class<?>... classes) throws InterpretationException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call '");
        sb.append(method);
        sb.append("' using types: ");
        for (Class<?> clazz : classes) {
            sb.append(clazz);
            sb.append(" ");
        }
        return sb.toString();
    }

    public TypeModel<?> and(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("and", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> or(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("or", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> add(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("add", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> sub(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("sub", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> mul(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("mul", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> div(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("div", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> mod(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("mod", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> not() throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("not", getTypeModelClass()));
    }

    public TypeModel<?> eq(TypeModel<?> typeModel) throws InterpretationException {
        return new TBool(getValue().equals(typeModel.getValue()));
    }

    public TypeModel<?> neq(TypeModel<?> typeModel) throws InterpretationException {
        return new TBool(!getValue().equals(typeModel.getValue()));
    }

    public TypeModel<?> lt(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("lt", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> gt(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("gt", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> lte(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("lte", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public TypeModel<?> gte(TypeModel<?> typeModel) throws InterpretationException {
        throw new InterpretationException(
                createTypeCheckException("gte", getTypeModelClass(), typeModel.getTypeModelClass()));
    }

    public abstract Class<T> getTypeModelClass();

    public T getValue() {
        return value;
    }

    public TypeModel(T value) {
        this.value = value;
    }
}
