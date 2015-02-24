package lang.ql.ast.expression;

/**
 * Created by bore on 17/02/15.
 */
public class Lt extends BinaryExpr
{
    public Lt(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
