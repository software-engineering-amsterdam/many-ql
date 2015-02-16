package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class BooleanLiteral extends Expression {

    private boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean getValue() {
        return value;
    }

}
