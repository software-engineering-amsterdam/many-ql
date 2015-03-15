package org.fugazi.ql.ast.expression;

public abstract class Binary extends Expression {

    private final Expression left;
    private final Expression right;

    public Binary(Expression _left, Expression _right) {
        super();
        this.left = _left;
        this.right = _right;
    }

    public Binary(Expression _left, Expression _right, int _lineNum) {
        super(_lineNum);
        this.left = _left;
        this.right = _right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}