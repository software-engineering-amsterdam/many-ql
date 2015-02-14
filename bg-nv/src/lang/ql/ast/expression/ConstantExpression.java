package lang.ql.ast.expression;

import lang.ql.ast.AstNode;

/**
 * Created by bore on 10/02/15.
 */
public abstract class ConstantExpression<T> extends Expression
{
    protected T value;

    public ConstantExpression(T value)
    {
        this.value = value;
    }

    public T getConstValue()
    {
        return this.value;
    }

    @Override
    public ConstantExpression getValue()
    {
        return this;
    }

    public Iterable<? extends AstNode> getChildren()
    {
        return null;
    }
}
