package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.Binary;
import org.fugazi.ast.expression.Expression;

public abstract class Logical extends Binary {

    public Logical(Expression _left, Expression _right) {
        super(_left, _right);
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}