package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public abstract class NumericBinaryOperatorExpression<IntegerExpression> extends BinaryOperatorExpression
{
    public NumericBinaryOperatorExpression(Expression left, Expression right)
    {
        super(left, right);
    }
//    public NumericBinaryOperatorExpression(IntegerExpression left, IntegerExpression right)
//    {
//        super(left, right);
//    }
}
