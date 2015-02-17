package org.fugazi.ast.expression;

public abstract class Binary extends Expression {

    protected final Expression left;

    protected final Expression right;

    public Binary(Expression _left, Expression _right) {
        left = _left;
        right = _right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}