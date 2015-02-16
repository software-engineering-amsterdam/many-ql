package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class IntegerLiteral extends Expression {

    private int value;

    public IntegerLiteral(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int getValue() {
        return value;
    }

}
