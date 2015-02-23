package parser.nodes.type;

import parser.nodes.AbstractNode;
import parser.nodes.expression.Expression;
import parser.Visitor;

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
    public boolean isConditional() {
        return true;
    }
}
