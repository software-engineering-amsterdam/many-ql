package org.fugazi.ast.literal;

public interface ILiteralVisitor<T> {

    public T visitID(ID idLiteral);
    public T visitSTRING(STRING stringLiteral);
    public T visitNUMBER(NUMBER numberLiteral);
}
