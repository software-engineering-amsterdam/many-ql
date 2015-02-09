package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class SubtractionExpression extends BinaryOperatorExpression<IntegerExpression>
{
    public SubtractionExpression(IntegerExpression left, IntegerExpression right)
    {
        super(left, right);
    }

    @Override
    public Expression getValue()
    {
        IntegerExpression result = new IntegerExpression(this.getLeft().getConstValue() + this.getRight().getConstValue());
        return result;
    }
}
