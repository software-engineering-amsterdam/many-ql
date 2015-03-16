package ql.ast.expression;

import ql.ast.type.Type;

/**
 * Created by bore on 09/02/15.
 */
public class Add extends BinaryExpr
{
    public Add(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public boolean isTypeCompatibleWithExpr(Type t)
    {
        return t.isNumerical() || t.isString();
    }

    @Override
    public Type getReturnType(Type childType)
    {
        return childType;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
