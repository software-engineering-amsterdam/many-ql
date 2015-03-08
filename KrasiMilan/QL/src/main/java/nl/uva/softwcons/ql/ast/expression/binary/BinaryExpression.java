package nl.uva.softwcons.ql.ast.expression.binary;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.type.Type;

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

    @Override
    public LineInfo getLineInfo() {
        return leftExpression.getLineInfo();
    }

    /**
     * An method that resolves the resulting type of carrying on the concrete
     * expression with the two given types.
     * 
     * @param type
     *            The type of the one expression
     * @param otherType
     *            The type of the other expression
     * @return The resulting type when the operation is allowed and Undefined
     *         otherwise
     */
    public abstract Type resolveType(Type type, Type otherType);

}
