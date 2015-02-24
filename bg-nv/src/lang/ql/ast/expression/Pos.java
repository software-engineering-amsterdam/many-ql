package lang.ql.ast.expression;

/**
 * Created by bore on 14/02/15.
 */
public class Pos extends UnaryExpr
{
    public Pos(Expr operand, int lineNumber)
    {
        super(operand, lineNumber);
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
