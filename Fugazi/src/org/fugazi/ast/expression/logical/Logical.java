package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.Binary;
import org.fugazi.ast.expression.Expression;

public abstract class Logical extends Binary {

    public Logical(Expression _left, Expression _right, int _lineNum) {
        super(_left, _right, _lineNum);
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}