package nl.uva.softwcons.ql.ast.expression.literal;

import java.math.BigDecimal;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class NumberLiteral extends Expression {
    private BigDecimal value;
    private LineInfo lineInfo;

    public NumberLiteral(double value, LineInfo lineInfo) {
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
