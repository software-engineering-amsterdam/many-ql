package org.fugazi.ast.expression;

public abstract class BinaryExpression extends Expression {

    protected Expression leftExpr;

    protected Expression rightExpr;

    public BinaryExpression(Expression _leftExpr, Expression _rightExpr) {
        leftExpr = _leftExpr;
        rightExpr = _rightExpr;
    }

    public Expression getLeftExpr() {
        return this.leftExpr;
    }

    public Expression getRightExpr() {
        return this.rightExpr;
    }
}