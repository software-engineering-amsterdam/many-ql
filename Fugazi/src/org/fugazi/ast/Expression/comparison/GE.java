package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;

public class GE extends Comparison {

    public GE(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public String toString() {
        return this.left.toString() + " >= " + this.right.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitGE(this);
    }
}