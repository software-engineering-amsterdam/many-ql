package nl.uva.softwcons.ql.ast.expression.literal;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class StringLiteral extends Expression {
    private String value;
    private LineInfo lineInfo;

    public StringLiteral(String value, LineInfo lineInfo) {
        this.value = value;
        this.lineInfo = lineInfo;
    }

    public String getValue() {
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
