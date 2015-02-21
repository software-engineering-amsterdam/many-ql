package lang.ql.ast.expression;

/**
 * Created by bore on 14/02/15.
 */
public abstract class UnaryExpr extends Expr
{
    private Expr operand;

    public UnaryExpr(Expr operand, int lineNumber)
    {
        super(lineNumber);
        this.operand = operand;
    }

    public Expr getOperand()
    {
        return this.operand;
    }
}
