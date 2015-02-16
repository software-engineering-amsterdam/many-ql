package org.fugazi.ast.Expression.logical;

import org.fugazi.ast.Expression.BinaryExpression;
import org.fugazi.ast.Expression.Expression;

public abstract class LogicalExpression extends BinaryExpression {

    public LogicalExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    public Expression getLeftExpr() {
        return leftExpr;
    }

    public Expression getRightExpr() {
        return rightExpr;
    }
}