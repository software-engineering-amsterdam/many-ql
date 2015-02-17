package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryOperator extends Expression
{
    private Expression left;
    private Expression right;

    public BinaryOperator(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft()
    {
        return this.left;
    }

    public Expression getRight() { return this.right; }
}
