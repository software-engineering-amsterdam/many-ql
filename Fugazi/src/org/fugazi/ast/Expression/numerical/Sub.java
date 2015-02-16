package org.fugazi.ast.expression.numerical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.IASTVisitor;

public class Sub extends Numerical {

    public Sub(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        return this.left.toString() + " - " + this.right.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitSub(this);
    }
}