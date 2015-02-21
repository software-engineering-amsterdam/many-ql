package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.type.Type;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public abstract class ComparisonExpression extends BinaryExpression {

    private static final Table<Type, Type, Type> COMPARISON_OPERATORS_TABLE = HashBasedTable.create();
    static {
        COMPARISON_OPERATORS_TABLE.put(Type.INTEGER, Type.INTEGER, Type.BOOLEAN);
        COMPARISON_OPERATORS_TABLE.put(Type.INTEGER, Type.DECIMAL, Type.BOOLEAN);
        COMPARISON_OPERATORS_TABLE.put(Type.DECIMAL, Type.INTEGER, Type.BOOLEAN);
        COMPARISON_OPERATORS_TABLE.put(Type.DECIMAL, Type.DECIMAL, Type.BOOLEAN);
    }

    public ComparisonExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for comparison expressions - {@link LowerThanExpression},
     * {@link LowerOrEqualExpression}, {@link GreaterThanExpression},
     * {@link GreaterOrEqualExpression}.
     */
    public static Type resolveType(final Type type, final Type otherType) {
        final Type resolvedType = COMPARISON_OPERATORS_TABLE.get(type, otherType);
        return resolvedType != null ? resolvedType : Type.UNDEFINED;
    }

}
