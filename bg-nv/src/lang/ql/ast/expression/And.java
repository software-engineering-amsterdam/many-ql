package lang.ql.ast.expression;

/**
 * Created by bore on 16/02/15.
 */
public class And extends BinaryExpr
{
    public And(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
