package parser.nodes.type;

import parser.nodes.AbstractNode;
import parser.nodes.expression.Expression;
import parser.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Number extends Expression {

    private final Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean isConditional() {
        return false;
    }
}
