package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.eval.value.BooleanValue;

public class BooleanExpression extends Expression {

    boolean value;

    public BooleanExpression(boolean value) {
        this.value = value;
    }

    @Override
    public BooleanValue evaluate() {
        // TODO Auto-generated method stub
        return new BooleanValue(value);
    }

}
