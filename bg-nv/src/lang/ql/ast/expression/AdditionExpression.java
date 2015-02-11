package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class AdditionExpression extends BinaryOperatorExpression
{
    public AdditionExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public ConstantExpression getValue()
    {
        ConstantExpression left = this.getLeft().getValue();
        IntegerExpression result = new IntegerExpression(5);
        return result;
    }
}
