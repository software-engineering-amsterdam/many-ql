package ql.ast.expression;

import ql.ast.type.BoolType;
import ql.ast.type.Type;

/**
 * Created by bore on 14/02/15.
 */
public abstract class UnaryExpr extends NaryExpr
{
    private final Expr operand;

    public UnaryExpr(Expr operand, int lineNumber)
    {
        super(lineNumber);
        this.operand = operand;
    }

    public Expr getOperand()
    {
        return this.operand;
    }

    @Override
    public Type getReturnType(Type childType)
    {
        return new BoolType();
    }
}
