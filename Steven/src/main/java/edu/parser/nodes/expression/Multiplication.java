package edu.parser.nodes.expression;

import edu.parser.Visitor;
import edu.parser.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Multiplication extends BinaryExpression {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isConditional() {
        return false;
    }
}
