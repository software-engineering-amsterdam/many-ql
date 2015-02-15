package nl.uva.softwcons.ast.expression.binary;

import nl.uva.softwcons.ast.expression.Expression;

public abstract class BinaryExpression extends Expression {

    protected Expression leftExpression;
    protected Expression rightExpression;

    public BinaryExpression(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

}
