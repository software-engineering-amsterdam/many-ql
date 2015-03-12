package edu.parser.QL.nodes.expression;

import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class GreaterThan extends BinaryExpression {
    public GreaterThan(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }

    @Override
    public GreaterThan clone() throws CloneNotSupportedException {
        return new GreaterThan(getLeft().clone(), getRight().clone());
    }
}
