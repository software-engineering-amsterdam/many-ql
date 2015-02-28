package edu.parser.QL.nodes.expression;

import edu.parser.QL.Visitor;
import edu.parser.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class LessThan extends BinaryExpression {
    public LessThan(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }
}
