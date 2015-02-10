package org.fugazi.ast.Expression;

/**
 * The Not '!'.
 */
public class NotExpression extends SingleExpression {

    public NotExpression(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "! " + this.expr.toString();
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}