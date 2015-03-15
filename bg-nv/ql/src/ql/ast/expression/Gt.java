package ql.ast.expression;

import ql.ast.type.BoolType;
import ql.ast.type.Type;

/**
 * Created by bore on 14/02/15.
 */
public class Gt extends BinaryExpr
{
    public Gt(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public boolean isTypeCompatibleWithExpr(Type t)
    {
        return t.isNumerical();
    }

    @Override
    public Type getReturnType(Type childType)
    {
        return new BoolType();
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
