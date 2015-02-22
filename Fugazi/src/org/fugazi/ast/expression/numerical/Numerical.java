package org.fugazi.ast.expression.numerical;

import org.fugazi.ast.expression.Binary;
import org.fugazi.ast.expression.Expression;

public abstract class Numerical extends Binary {

    public Numerical(Expression _left, Expression _right) {
        super(_left, _right);
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}