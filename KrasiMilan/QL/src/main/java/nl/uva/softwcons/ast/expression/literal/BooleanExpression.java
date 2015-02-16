package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;

public class BooleanExpression extends Expression {

    private boolean value;

    public BooleanExpression(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

}
