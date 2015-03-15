package ql.ast.expression;

/**
 * Created by bore on 10/02/15.
 */
public class BoolExpr extends ConstExpr<Boolean>
{
    public BoolExpr(Boolean value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
