package nl.uva.softwcons.ast.expression.literal;

import java.math.BigDecimal;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class DecimalLiteral extends Expression {
    private BigDecimal value;
    private LineInfo lineInfo;

    public DecimalLiteral(double value, LineInfo lineInfo) {
        this.value = new BigDecimal(value);
        this.lineInfo = lineInfo;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public LineInfo getLineInfo() {
        return this.lineInfo;
    }

}
