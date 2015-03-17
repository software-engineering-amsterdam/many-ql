package edu.parser.QL.nodes.expression;

import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Subtraction extends BinaryExpression {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }

    @Override
    public AbstractNode accept(ExpressionVisitor expressionVisitor) {
        return expressionVisitor.visit(this);
    }
}
