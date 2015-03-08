package nl.uva.softwcons.ql.ast.expression.binary.comparison;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import static nl.uva.softwcons.ql.ast.type.StringType.STRING_TYPE;
import static nl.uva.softwcons.ql.ast.type.UndefinedType.UNDEFINED_TYPE;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.type.Type;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public abstract class EqualityExpression extends BinaryExpression {
    private static final Table<Type, Type, Type> EQUALITY_OPERATORS_TABLE = HashBasedTable.create();
    static {
        EQUALITY_OPERATORS_TABLE.put(NUMBER_TYPE, NUMBER_TYPE, BOOLEAN_TYPE);
        EQUALITY_OPERATORS_TABLE.put(STRING_TYPE, STRING_TYPE, BOOLEAN_TYPE);
        EQUALITY_OPERATORS_TABLE.put(BOOLEAN_TYPE, BOOLEAN_TYPE, BOOLEAN_TYPE);
    }
    private final LineInfo lineInfo;

    public EqualityExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right);

        this.lineInfo = lineInfo;
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for equality expressions - {@link Equal}, {@link NotEqual}
     */
    public static Type resolveType(final Type type, final Type otherType) {
        final Type resolvedType = EQUALITY_OPERATORS_TABLE.get(type, otherType);
        return resolvedType != null ? resolvedType : UNDEFINED_TYPE;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}
