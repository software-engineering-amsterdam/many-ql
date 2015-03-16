package ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class StrExpr extends ConstExpr<String>
{
    public StrExpr(String value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
