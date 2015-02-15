package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.eval.value.StringValue;

public class StringExpression extends Expression {

    String value;

    public StringExpression(String value) {
        this.value = value;
    }

    @Override
    public StringValue evaluate() {
        // TODO Auto-generated method stub
        return new StringValue(this.value);
    }

}
