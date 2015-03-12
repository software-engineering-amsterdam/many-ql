package edu.parser.QL.nodes.type;

import edu.gui.components.store.Store;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.ExpressionVisitor;

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
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean hasBooleanOperands() {
        return false;
    }

    @Override
    public Expression accept(ExpressionVisitor expressionVisitor) {
        return expressionVisitor.visit(this);
    }

    @Override
    public String getValue() {
        return toString();
    }
}
