package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class SubtractionExpression extends BinaryOperatorExpression
{
    public SubtractionExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public ConstantExpression getValue()
    {
        ReturnIntegerExpression result = new ReturnIntegerExpression(5);
        return result;
    }
}
