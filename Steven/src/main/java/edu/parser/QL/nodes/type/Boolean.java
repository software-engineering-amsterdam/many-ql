package edu.parser.QL.nodes.type;

import edu.gui.components.store.Store;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.nodes.expression.ExpressionVisitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Boolean extends Expression implements Store {

    private final boolean state;

    public Boolean(boolean state) {
        this.state = state;
    }

    public boolean isTrue() {
        return state;
    }

    @Override
    public boolean hasBooleanOperands() {
        return true;
    }

    @Override
    public Expression accept(ExpressionVisitor expressionVisitor) {
        return expressionVisitor.visit(this);
    }

    @Override
    public String getValue() {
        return String.valueOf(state);
    }
}
