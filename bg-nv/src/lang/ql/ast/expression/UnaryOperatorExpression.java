package lang.ql.ast.expression;

import lang.ql.ast.AstNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bore on 14/02/15.
 */
public class UnaryOperatorExpression extends Expression
{
    private Expression operand;

    public UnaryOperatorExpression(Expression operand)
    {
        this.operand = operand;
    }

    public Expression getOperand()
    {
        return this.operand;
    }

    public Iterable<? extends AstNode> getChildren()
    {
        return Arrays.asList(this.operand);
    }
}
