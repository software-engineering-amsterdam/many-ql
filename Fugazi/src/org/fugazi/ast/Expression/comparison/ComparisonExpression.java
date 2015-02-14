package org.fugazi.ast.Expression.comparison;

import org.fugazi.ast.Expression.BinaryExpression;
import org.fugazi.ast.Expression.Expression;

/**
 * The ComparisonExpression class. An abstract class the express a ComparisonExpression.
 * It is a Node of the AST, and an expression.
 */
public abstract class ComparisonExpression extends BinaryExpression {

    // The left expression
    protected Expression leftExpr;

    // The right expression
    protected Expression rightExpr;

    /**
     * Constructor.
     * @param _leftExpr The left expression
     * @param _rightExpr The right expression
     */
    public ComparisonExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    public Expression getLeftExpr() {
        return leftExpr;
    }

    public Expression getRightExpr() {
        return rightExpr;
    }
}