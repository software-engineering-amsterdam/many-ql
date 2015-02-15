package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.eval.value.IntegerValue;

public class IntegerExpression extends Expression {

    int value;

    public IntegerExpression(int value) {
        this.value = value;
    }

    @Override
    public IntegerValue evaluate() {
        // TODO Auto-generated method stub
        return new IntegerValue(this.value);
    }

}
