package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class ReturnIntegerExpression extends ConstantExpression<Integer> implements IReturnInteger
{
    public ReturnIntegerExpression(int value)
    {
        super(value);
    }

    @Override
    public int getIntegerValue()
    {
        return this.value;
    }
}
