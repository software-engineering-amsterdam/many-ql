package nl.uva.softwcons.ast.expression.identifier;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class IdentifierExpression extends Expression {
    private String name;

    public IdentifierExpression(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }

}
