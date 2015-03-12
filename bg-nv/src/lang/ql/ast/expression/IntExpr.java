package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class IntExpr extends ConstExpr<Integer>
{
    public IntExpr(int value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
