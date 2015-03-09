package lang.ql.ast.expression;

import lang.ql.ast.type.Type;

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
    public Type getComputedType(Type childType)
    {
        return childType;
    }

    @Override
    public boolean isTypeAllowed(Type t)
    {
        return t.isArithmetic() || t.isString();
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
