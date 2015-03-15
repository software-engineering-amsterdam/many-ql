package ql.ast.expression;

import ql.ast.type.Type;

/**
 * Created by bore on 17/02/15.
 */
public class Div extends BinaryExpr
{
    public Div(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public boolean isTypeAllowed(Type t)
    {
        return t.isNumerical();
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
