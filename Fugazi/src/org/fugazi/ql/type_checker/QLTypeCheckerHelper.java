package org.fugazi.ql.type_checker;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;

/*
 * Static class for checks used by multiple visitors.
 */
public class QLTypeCheckerHelper {

    public static boolean isDefined(ID idLiteral) {
        return (idLiteral.getType() != null);
    }

    public static boolean isExpressionOfTypeBool(Expression expression) {
        return isExpressionOfType(expression, new BoolType());
    }

    public static boolean isExpressionOfTypeInt(Expression expression) {
        return isExpressionOfType(expression, new IntType());
    }

    public static boolean isExpressionOfTypeString(Expression expression) {
        return isExpressionOfType(expression, new StringType());
    }

    public static boolean isExpressionOfType(Expression expression, Type type) {
        return areTypesEqual(expression.getReturnedType(), type);
    }

    public static boolean areTypesEqual(Type type1, Type type2) {
        return type1.equals(type2);
    }
}
