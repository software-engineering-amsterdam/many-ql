package org.fugazi.ql.type_checker.helper;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.type.*;

/*
 * Static class for checks used by multiple visitors.
 */
public class QLTypeCheckerHelper {

    // TODO put it in expression

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
