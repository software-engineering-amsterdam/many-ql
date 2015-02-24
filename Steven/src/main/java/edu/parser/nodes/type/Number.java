package edu.parser.nodes.type;

import edu.parser.nodes.AbstractNode;
import edu.parser.nodes.expression.Expression;
import edu.parser.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Number extends Expression {

    private final int value;

    public Number(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }
}
