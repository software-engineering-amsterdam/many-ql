package org.fugazi.ast.type;

public interface ITypeVisitor<T> {
    public T visitBoolType(BoolType boolType);
    public T visitIntType(IntType intType);
    public T visitStringType(StringType moneyType);
}

