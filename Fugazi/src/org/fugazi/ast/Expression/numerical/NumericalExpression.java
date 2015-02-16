package org.fugazi.ast.expression.numerical;

import org.fugazi.ast.expression.BinaryExpression;
import org.fugazi.ast.expression.Expression;

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