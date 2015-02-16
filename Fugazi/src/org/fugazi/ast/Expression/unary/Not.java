package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.IASTVisitor;

public class Not extends Unary {

    public Not(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "! " + this.expr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitNotExpression(this);
    }
}