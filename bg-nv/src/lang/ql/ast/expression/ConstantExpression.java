package lang.ql.ast.expression;

import lang.ql.ast.AstNode;

import java.util.Collections;

/**
 * Created by bore on 10/02/15.
 */
public abstract class ConstantExpression<T> extends Expression
{
    // TODO: Add Date constant expression
    protected T value;

    public ConstantExpression(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }

    public Iterable<? extends AstNode> getChildren()
    {
        return Collections.emptyList();
    }
}
