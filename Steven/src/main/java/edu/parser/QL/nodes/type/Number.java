package edu.parser.QL.nodes.type;

import edu.gui.components.store.Store;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Number extends Expression implements Store {

    private final int number;

    public Number(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }

    @Override
    public String getValue() {
        return toString();
    }
}
