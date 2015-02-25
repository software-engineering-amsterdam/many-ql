package nl.uva.softwcons.ast.expression.binary.logical;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.type.Type;

public abstract class LogicalExpression extends BinaryExpression {
    public LogicalExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for comparison expressions - {@link And},
     * {@link Or}
     */
    public static Type resolveType(final Type type, final Type otherType) {
        if (type == Type.BOOLEAN && otherType == Type.BOOLEAN) {
            return Type.BOOLEAN;
        }

        return Type.UNDEFINED;
    }

}
