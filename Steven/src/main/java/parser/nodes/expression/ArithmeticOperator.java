package parser.nodes.expression;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class ArithmeticOperator extends BinaryExpression {
    public ArithmeticOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean isConditional() {
        return false;
    }

}
