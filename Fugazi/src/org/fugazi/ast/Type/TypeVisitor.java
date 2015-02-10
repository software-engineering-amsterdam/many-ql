package org.fugazi.ast.Type;

/**
 * Generic Visitor classs for types.
 * @param <T>
 */
public interface TypeVisitor<T> {

    public T visit(BoolType boolType);
    public T visit(IntType intrType);
    public T visit(MoneyType moneyType);
    public T visit(UndefinedType undefinedType);
}

