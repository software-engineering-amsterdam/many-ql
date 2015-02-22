package parser.nodes.type;

import parser.nodes.expression.Expression;
import typeChecker.Visitor;

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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
