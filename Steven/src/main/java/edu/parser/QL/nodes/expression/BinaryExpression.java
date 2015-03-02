package edu.parser.QL.nodes.expression;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public abstract class BinaryExpression extends Expression {

    private final Expression left;
    private final Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String toString() {
        return "left:" + left + " right: " + right;
    }


}
