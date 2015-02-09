package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryOperatorExpression<T extends Expression> extends Expression
{
    private T left;
    private T right;

    public BinaryOperatorExpression(T left, T right)
    {
        this.left = left;
        this.right = right;
    }

    public T getLeft()
    {
        return this.left;
    }

    public T getRight()
    {
        return this.right;
    }
}
