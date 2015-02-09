package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class IntegerExpression extends Expression
{
    private int value;

    public IntegerExpression(int value)
    {
        this.value = value;
    }

    @Override
    public Expression getValue()
    {
        return this;
    }

    public int getConstValue()
    {
        return this.value;
    }
}
