package nl.uva.softwcons.ast.expression.literal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class StringLiteral extends Expression {

    private String value;

    public StringLiteral(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getValue() {
        return value;
    }

}
