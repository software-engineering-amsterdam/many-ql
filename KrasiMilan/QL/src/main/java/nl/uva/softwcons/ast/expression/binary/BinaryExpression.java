package nl.uva.softwcons.ast.expression.binary;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.type.Type;

public abstract class BinaryExpression extends Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public BinaryExpression(final Expression left, final Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    /**
     * An "abstract" static method (in the sense in which Java doesn't support
     * abstract static methods) that resolves the resulting type of carrying on
     * the concrete expression with the two given types.
     * 
     * @param type
     *            The type of the one expression
     * @param otherType
     *            The type of the other expression
     * @return The resulting type when the operation is allowed and Undefined
     *         otherwise
     */
    public static Type resolveType(final Type type, final Type otherType) {
        throw new AssertionError("This method should be overriden by subclasses!");
    }

}
