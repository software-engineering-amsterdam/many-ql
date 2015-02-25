package nl.uva.softwcons.ast.expression.literal;

import java.math.BigDecimal;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class DecimalLiteral extends Expression {

    private BigDecimal value;

    public DecimalLiteral(final BigDecimal value) {
        this.value = value;
    }

    public DecimalLiteral(final double value) {
        this.value = new BigDecimal(value);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public BigDecimal getValue() {
        return value;
    }

}
