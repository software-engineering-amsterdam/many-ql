package org.fugazi.ast.type;

public interface ITypeVisitor<T> {
    /**
     * ==============
     * Types
     * ==============
     */
    public T visitBoolType(BoolType boolType);
    public T visitIntType(IntType intType);
    public T visitStringType(StringType moneyType);
    public T visitUndefinedType(UndefinedType undefinedType);
}

