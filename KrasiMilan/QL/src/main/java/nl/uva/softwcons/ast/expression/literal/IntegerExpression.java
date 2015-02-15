package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;

public class IntegerExpression extends Expression {

    private int value;

    public IntegerExpression(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
