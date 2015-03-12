package edu.parser.QL.nodes.expression;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Not extends UnaryExpression {

    public Not(Expression operand) {
        super(operand);
    }

    @Override
    public Expression accept(ExpressionVisitor expressionVisitor) {
        return expressionVisitor.visit(this);
    }

    @Override
    public boolean hasBooleanOperands() {
        return true;
    }
}
