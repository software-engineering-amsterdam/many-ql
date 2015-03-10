package lang.ql.ast.expression;

import lang.ql.ast.type.BoolType;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 17/02/15.
 */
public class Lt extends BinaryExpr
{
    public Lt(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public Type getComputedType(Type childType)
    {
        return new BoolType();
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
