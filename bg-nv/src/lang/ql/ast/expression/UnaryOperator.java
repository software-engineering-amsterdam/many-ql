package lang.ql.ast.expression;

/**
 * Created by bore on 14/02/15.
 */
public class UnaryOperator extends Expression
{
    private Expression operand;

    public UnaryOperator(Expression operand)
    {
        this.operand = operand;
    }

    public Expression getOperand()
    {
        return this.operand;
    }
}
