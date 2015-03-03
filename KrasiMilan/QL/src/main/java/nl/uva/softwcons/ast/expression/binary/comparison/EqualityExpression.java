package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.type.BooleanType;
import nl.uva.softwcons.ast.type.NumberType;
import nl.uva.softwcons.ast.type.StringType;
import nl.uva.softwcons.ast.type.Type;
import nl.uva.softwcons.ast.type.UndefinedType;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public abstract class EqualityExpression extends BinaryExpression {
    private static final Table<Type, Type, Type> EQUALITY_OPERATORS_TABLE = HashBasedTable.create();
    static {
        EQUALITY_OPERATORS_TABLE.put(NumberType.instance, NumberType.instance, BooleanType.instance);
        EQUALITY_OPERATORS_TABLE.put(StringType.instance, StringType.instance, BooleanType.instance);
        EQUALITY_OPERATORS_TABLE.put(BooleanType.instance, BooleanType.instance, BooleanType.instance);
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
        return resolvedType != null ? resolvedType : UndefinedType.instance;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}
