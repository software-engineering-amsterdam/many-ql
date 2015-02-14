package org.fugazi.ast.Expression;

/**
 * The BinaryExpression class. An abstract class the express a BinaryExpression.
 * In mathematics, a binary operation on a set is a calculation that combines two elements of the set (called operands) to produce another element of the set
 * It is a Node of the AST, and an expression.
 */
public abstract class BinaryExpression extends Expression {

    // The left expression
    protected Expression leftExpr;

    // The right expression
    protected Expression rightExpr;

    /**
     * Constructor.
     * @param _leftExpr The left expression
     * @param _rightExpr The right expression
     */
    public BinaryExpression(Expression _leftExpr, Expression _rightExpr) {
        leftExpr = _leftExpr;
        rightExpr = _rightExpr;
    }

    public Expression getLeftExpr() {
        return leftExpr;
    }

    public Expression getRightExpr() {
        return rightExpr;
    }
}