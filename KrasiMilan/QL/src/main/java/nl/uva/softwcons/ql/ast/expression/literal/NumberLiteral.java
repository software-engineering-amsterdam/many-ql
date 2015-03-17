package nl.uva.softwcons.ql.ast.expression.literal;

import java.math.BigDecimal;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class NumberLiteral extends Expression {
    private final BigDecimal value;

    public NumberLiteral(final double value, final LineInfo lineInfo) {
        super(lineInfo);
        this.value = new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public <T> T accept(final ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
