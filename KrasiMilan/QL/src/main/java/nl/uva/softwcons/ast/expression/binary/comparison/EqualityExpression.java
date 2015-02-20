package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.type.Type;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public abstract class EqualityExpression extends BinaryExpression {
    private static final Table<Type, Type, Type> EQUALITY_OPERATORS_TABLE = HashBasedTable.create();
    static {
        EQUALITY_OPERATORS_TABLE.put(Type.INTEGER, Type.INTEGER, Type.BOOLEAN);
        EQUALITY_OPERATORS_TABLE.put(Type.INTEGER, Type.DECIMAL, Type.BOOLEAN);
        EQUALITY_OPERATORS_TABLE.put(Type.DECIMAL, Type.INTEGER, Type.BOOLEAN);
        EQUALITY_OPERATORS_TABLE.put(Type.DECIMAL, Type.DECIMAL, Type.BOOLEAN);
        EQUALITY_OPERATORS_TABLE.put(Type.STRING, Type.STRING, Type.BOOLEAN);
        EQUALITY_OPERATORS_TABLE.put(Type.BOOLEAN, Type.BOOLEAN, Type.BOOLEAN);
    }

    public EqualityExpression(final Expression left, final Expression right) {
        super(left, right);
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for equality expressions - {@link EqualExpression},
     * {@link NotEqualExpression}
     */
    public static Type resolveType(final Type type, final Type otherType) {
        final Type resolvedType = EQUALITY_OPERATORS_TABLE.get(type, otherType);
        return resolvedType != null ? resolvedType : Type.UNDEFINED;
    }

}
