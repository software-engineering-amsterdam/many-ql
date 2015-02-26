package nl.uva.softwcons.ast.expression.identifier;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class Identifier extends Expression {
    private String name;
    private LineInfo lineInfo;

    public Identifier(String name, LineInfo lineInfo) {
        this.name = name;
        this.lineInfo = lineInfo;
    }

    public String getName() {
        return name;
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
