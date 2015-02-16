package org.fugazi.ast.Expression;

/**
 * The SingleExpression class. An abstract class the express a SingleExpression.
 * It is a Node of the AST, and an expression.
 */
public abstract class SingleExpression extends Expression {

    // The expression
    protected Expression expr;

    /**
     * Constructor.
     * @param _expr The expression
     */
    public SingleExpression(Expression _expr) {
        expr = _expr;
    }

    public Expression getExpr() {
        return expr;
    }
}