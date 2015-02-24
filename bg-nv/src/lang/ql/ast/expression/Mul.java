package lang.ql.ast.expression;

/**
 * Created by bore on 17/02/15.
 */
public class Mul extends BinaryExpr
{
    public Mul(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}