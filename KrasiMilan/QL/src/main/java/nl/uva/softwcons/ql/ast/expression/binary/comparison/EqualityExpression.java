package nl.uva.softwcons.ql.ast.expression.binary.comparison;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static nl.uva.softwcons.ql.ast.type.UndefinedType.UNDEFINED_TYPE;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.type.Type;

public abstract class EqualityExpression extends BinaryExpression {

    public EqualityExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for equality expressions - {@link Equal},{@link NotEqual}.
     * These expressions resolve to boolean type only if both their operands are
     * from the same type (except for two undefined values). All other given
     * types will result in an undefined type for the whole expression.
     * 
     */
    @Override
    public Type resolveType(final Type type, final Type otherType) {
        if (type == otherType && type != UNDEFINED_TYPE) { // NOPMD
            return BOOLEAN_TYPE;
        }

        return UNDEFINED_TYPE;
    }

}
