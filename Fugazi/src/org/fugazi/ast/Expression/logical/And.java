package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.expression.Expression;

public class And extends Logical {

    public And(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        return this.left.toString() + " && " + this.right.toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitAnd(this);
    }
}