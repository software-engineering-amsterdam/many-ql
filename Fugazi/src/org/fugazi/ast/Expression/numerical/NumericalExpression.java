package org.fugazi.ast.Expression.numerical;

import org.fugazi.ast.Expression.BinaryExpression;
import org.fugazi.ast.Expression.Expression;

public abstract class NumericalExpression extends BinaryExpression {

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