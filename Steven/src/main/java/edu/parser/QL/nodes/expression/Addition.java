package edu.parser.QL.nodes.expression;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Addition extends BinaryExpression {
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }

    @Override
    public Expression accept(ExpressionVisitor expressionVisitor) {
        return expressionVisitor.visit(this);
    }
}
