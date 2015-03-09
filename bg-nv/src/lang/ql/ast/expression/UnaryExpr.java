package lang.ql.ast.expression;

import lang.ql.ast.type.BoolType;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 14/02/15.
 */
public abstract class UnaryExpr extends NaryExpr
{
    private Expr operand;

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
    public boolean isTypeAllowed(Type t)
    {
        return t.isArithmetic();
    }

    @Override
    public Type getComputedType(Type childType)
    {
        return new BoolType();
    }
}
