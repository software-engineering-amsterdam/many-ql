package org.fugazi.ql.ast.type;

public interface ITypeVisitor<T> {
    
    public T visitBoolType(BoolType _boolType);
    public T visitIntType(IntType _intType);
    public T visitStringType(StringType _stringType);
    public T visitUndefinedType(UndefinedType _undefinedType);
}

