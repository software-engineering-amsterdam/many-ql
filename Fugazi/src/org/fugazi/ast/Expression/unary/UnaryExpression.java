package org.fugazi.ast.Expression.unary;

import org.fugazi.ast.Expression.Expression;

/**
 * The UnaryExpression class. An abstract class the express an   UnaryExpression.
 * In mathematics, a unary operation is an operation with only one operand.
 * It is a Node of the AST, and an expression.
 */
public abstract class UnaryExpression extends Expression {

    // The expression
    protected Expression expr;

    /**
     * Constructor.
     * @param _expr The expression
     */
    public UnaryExpression(Expression _expr) {
        expr = _expr;
    }

    public Expression getExpr() {
        return expr;
    }
}