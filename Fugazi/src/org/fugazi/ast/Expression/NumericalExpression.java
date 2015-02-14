package org.fugazi.ast.Expression;

/**
 * The NumericalExpression class. An abstract class the express a NumericalExpression.
 * It is a Node of the AST, and an expression.
 */
public abstract class NumericalExpression extends BinaryExpression {

    // The left expression
    protected Expression leftExpr;

    // The right expression
    protected Expression rightExpr;

    /**
     * Constructor.
     * @param _leftExpr The left expression
     * @param _rightExpr The right expression
     */
    public NumericalExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    public Expression getLeftExpr() {
        return leftExpr;
    }

    public Expression getRightExpr() {
        return rightExpr;
    }
}