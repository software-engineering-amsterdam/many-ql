package lang.ql.ast.expression;

/**
 * Created by bore on 10/02/15.
 */
public abstract class ConstantExpr<T> extends Expression
{
    // TODO: Add Date constant expression
    protected T value;

    public ConstantExpr(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }
}
