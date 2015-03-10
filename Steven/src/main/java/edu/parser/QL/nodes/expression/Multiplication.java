package edu.parser.QL.nodes.expression;

import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Multiplication extends BinaryExpression {
    public Multiplication(Expression left, Expression right) {
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
    public Multiplication clone() throws CloneNotSupportedException {
        return new Multiplication(getLeft().clone(), getRight().clone());
    }
}
