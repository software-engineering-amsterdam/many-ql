package ql.ast.expression;

import ql.ast.type.BoolType;
import ql.ast.type.Type;

/**
 * Created by bore on 16/02/15.
 */
public class Or extends BinaryExpr
{
    public Or(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public boolean isTypeCompatibleWithExpr(Type t)
    {
        return t.isBool();
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
