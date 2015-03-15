package ql.ast.expression;

import ql.ast.type.Type;

/**
 * Created by bore on 14/02/15.
 */
public class Neg extends UnaryExpr
{
    public Neg(Expr operand, int lineNumber)
    {
        super(operand, lineNumber);
    }

    @Override
    public boolean isTypeAllowed(Type t)
    {
        return t.isNumerical();
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
