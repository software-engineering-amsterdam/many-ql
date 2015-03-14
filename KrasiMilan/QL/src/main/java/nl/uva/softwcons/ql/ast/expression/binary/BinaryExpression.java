package nl.uva.softwcons.ql.ast.expression.binary;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.type.Type;

public abstract class BinaryExpression extends Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public BinaryExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(lineInfo);
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
    public abstract Type resolveType(final Type type, final Type otherType);

}
