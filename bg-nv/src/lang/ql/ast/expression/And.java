package lang.ql.ast.expression;

import lang.ql.ast.type.BoolType;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 16/02/15.
 */
public class And extends BinaryExpr
{
    public And(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public boolean isTypeAllowed(Type t)
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
