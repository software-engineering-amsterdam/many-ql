package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.BinaryExpression;
import org.fugazi.ast.expression.Expression;

public abstract class ComparisonExpression extends BinaryExpression {

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