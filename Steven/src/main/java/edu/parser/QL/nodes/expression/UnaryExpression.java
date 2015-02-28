package edu.parser.QL.nodes.expression;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class UnaryExpression extends Expression {

    private final Expression operand;

    public UnaryExpression(Expression operand) {
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }
}
