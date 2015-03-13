package lang.ql.ast.expression;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 10/02/15.
 */
public abstract class ConstExpr<T> extends Expr
{
    protected final T value;

    public ConstExpr(T value, int lineNumber)
    {
        super(lineNumber);
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }
}
