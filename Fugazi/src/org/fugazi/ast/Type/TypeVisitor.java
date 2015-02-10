package org.fugazi.ast.Type;

/**
 * Generic Visitor class for types.
 * @param <T>
 */
public interface TypeVisitor<T> {

    public T visit(BoolType boolType);
    public T visit(IntType intType);
    public T visit(MoneyType moneyType);
    public T visit(UndefinedType undefinedType);
}

