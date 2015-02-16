package org.fugazi.ast.Expression.comparison;

import org.fugazi.ast.Expression.BinaryExpression;
import org.fugazi.ast.Expression.Expression;

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