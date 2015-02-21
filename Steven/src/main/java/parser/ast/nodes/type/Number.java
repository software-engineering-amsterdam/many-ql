package parser.ast.nodes.type;

import parser.ast.nodes.expression.Expression;

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
}
