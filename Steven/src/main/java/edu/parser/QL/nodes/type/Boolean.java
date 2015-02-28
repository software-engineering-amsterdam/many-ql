package edu.parser.QL.nodes.type;

import edu.parser.QL.nodes.AbstractNode;
import edu.parser.QL.nodes.expression.Expression;
import edu.parser.QL.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Boolean extends Expression {

    private final boolean state;

    public Boolean(boolean state) {
        this.state = state;
    }

    public boolean isTrue() {
        return state;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean hasBooleanOperands() {
        return true;
    }
}
