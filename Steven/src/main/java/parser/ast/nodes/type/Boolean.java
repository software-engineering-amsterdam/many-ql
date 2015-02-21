package parser.ast.nodes.type;

import parser.ast.nodes.expression.Expression;

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
}
