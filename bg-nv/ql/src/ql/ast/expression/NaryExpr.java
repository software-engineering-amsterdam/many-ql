package ql.ast.expression;

import ql.ast.type.Type;

/**
 * Created by bore on 09/03/15.
 */
public abstract class NaryExpr extends Expr
{
    public NaryExpr()
    {

    }

    public NaryExpr(int lineNumber)
    {
        super(lineNumber);
    }

    public abstract boolean isTypeCompatibleWithExpr(Type t);

    public abstract Type getReturnType(Type childType);

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return null;
    }
}
