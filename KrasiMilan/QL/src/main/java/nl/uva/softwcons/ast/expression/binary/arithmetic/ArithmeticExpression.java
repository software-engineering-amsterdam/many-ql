package nl.uva.softwcons.ast.expression.binary.arithmetic;

import nl.uva.softwcons.ast.LineInfo;
import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.type.Type;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public abstract class ArithmeticExpression extends BinaryExpression {
    private static final Table<Type, Type, Type> ARITHMENTIC_OPERATORS_TABLE = HashBasedTable.create();
    static {
        ARITHMENTIC_OPERATORS_TABLE.put(Type.INTEGER, Type.INTEGER, Type.INTEGER);
        ARITHMENTIC_OPERATORS_TABLE.put(Type.INTEGER, Type.DECIMAL, Type.DECIMAL);
        ARITHMENTIC_OPERATORS_TABLE.put(Type.DECIMAL, Type.INTEGER, Type.DECIMAL);
        ARITHMENTIC_OPERATORS_TABLE.put(Type.DECIMAL, Type.DECIMAL, Type.DECIMAL);
    }
    private final LineInfo lineInfo;

    public ArithmeticExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right);

        this.lineInfo = lineInfo;
    }

    public static Type resolveType(final Type type, final Type otherType) {
        final Type resolvedType = ARITHMENTIC_OPERATORS_TABLE.get(type, otherType);
        return resolvedType != null ? resolvedType : Type.UNDEFINED;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }
}
