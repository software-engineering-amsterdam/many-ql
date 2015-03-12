package edu.parser.QL.nodes.expression;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class And extends BinaryExpression {
    public And(Expression left, Expression right) {
        super(left, right);
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
