package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;

public class Less extends Comparison {

    public Less(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        return this.left.toString() + " < " + this.right.toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitLesser(this);
    }
}