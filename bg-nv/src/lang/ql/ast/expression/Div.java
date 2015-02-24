package lang.ql.ast.expression;

/**
 * Created by bore on 17/02/15.
 */
public class Div extends BinaryExpr
{
    public Div(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
