package nl.uva.softwcons.ql.ast.expression.binary.logical;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static nl.uva.softwcons.ql.ast.type.UndefinedType.UNDEFINED_TYPE;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.type.Type;

public abstract class LogicalExpression extends BinaryExpression {

    public LogicalExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for comparison expressions - {@link And}, {@link Or}.
     * These expressions resolve to boolean type only if both their operands are
     * of boolean type. All other given types result in an undefined type for
     * the whole expression.
     */
    @Override
    public Type resolveType(final Type type, final Type otherType) {
        if (type == BOOLEAN_TYPE && otherType == BOOLEAN_TYPE) {
            return BOOLEAN_TYPE;
        }

        return UNDEFINED_TYPE;
    }

}
