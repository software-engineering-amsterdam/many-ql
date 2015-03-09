package nl.uva.softwcons.ql.ast.expression.binary.comparison;

import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import static nl.uva.softwcons.ql.ast.type.UndefinedType.UNDEFINED_TYPE;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.type.Type;

public abstract class ComparisonExpression extends BinaryExpression {
    private final LineInfo lineInfo;

    public ComparisonExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right);

        this.lineInfo = lineInfo;
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for comparison expressions - {@link LowerThan},
     * {@link LowerOrEqual}, {@link GreaterThan}, {@link GreaterOrEqual}. These
     * expressions resolve to number type only if both their operands are of
     * number type. All other given types result in an undefined type for the
     * whole expression.
     */
    @Override
    public Type resolveType(final Type type, final Type otherType) {
        if (type == NUMBER_TYPE && otherType == NUMBER_TYPE) {
            return NUMBER_TYPE;
        }

        return UNDEFINED_TYPE;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}
