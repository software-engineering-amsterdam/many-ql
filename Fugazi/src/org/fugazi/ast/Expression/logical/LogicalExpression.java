package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.BinaryExpression;
import org.fugazi.ast.expression.Expression;

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