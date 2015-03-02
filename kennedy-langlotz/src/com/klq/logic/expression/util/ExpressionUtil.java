package com.klq.logic.expression.util;

import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.operator.bool.*;
import com.klq.logic.expression.operator.math.Addition;
import com.klq.logic.expression.operator.math.Division;
import com.klq.logic.expression.operator.math.Multiplication;
import com.klq.logic.expression.operator.math.Subtraction;
import com.klq.logic.expression.terminal.Boolean;
import com.klq.logic.expression.terminal.Date;
import com.klq.logic.expression.terminal.Number;
import com.klq.logic.question.Type;

/**
 * Created by Timon on 27.02.2015.
 */
public class ExpressionUtil {

    //TODO check if this works
    public static AExpression createTerminalFromString(Type type, String value){
        switch (type){
            case BOOLEAN:
                return createBooleanFromString(value);
            case DATE:
                return createDateFromString(value);
            case NUMERAL:
                return createNumberFromString(value);
            case STRING:
            case SET:
                return new com.klq.logic.expression.terminal.String(value);
        }
        return null;
    }

    private static Boolean createBooleanFromString(String value){
        String normalized = value.toLowerCase().trim();
        if (normalized.equals("yes") || normalized.equals("true"))
            return Boolean.getTrue();
        return Boolean.getFalse();
    }

    private static Date createDateFromString(String value){
        String[] split = value.split("[\\./-]");
        String year = "0000", month = "01", day = "01";
        if (split[0].length() == 4 && split[1].length() == 2 && split[2].length() == 2){
            year = split[0];
            month = split[1];
            day = split[2];
        } else if (split[2].length() == 4 && split[1].length() == 2 && split[0].length() == 2){
            day = split[0];
            month = split[1];
            year = split[2];
        }
        return new Date(year + "-" + month + "-" + day);
    }

    private static Number createNumberFromString(String value){
        //TODO pattern match
        return new Number(!value.isEmpty() ? value : "0");
    }

    /**
     * Copies an AExpression.
     *
     * @param current   The expression to copy.
     * @param newLeft   The new left child, or null if the original should be kept.
     * @param newRight  The new right child, or null if the original should be kept.
     * @return          A new instance of the given expression.
     */
    public static AExpression copyExpressionFrom(AExpression current, AExpression newLeft, AExpression newRight){
        AExpression left = (newLeft != null ? newLeft : current.getLeft());
        AExpression right = (newRight != null ? newRight : current.getRight());
        switch (current.getType()){
            case AExpression.ADD: return new Addition(left, right);
            case AExpression.AND: return new And(left, right);
            case AExpression.DIV: return new Division(left, right);
            case AExpression.EQUALS: return new Equals(left, right);
            case AExpression.GREATER_EQUALS: return new GreaterEquals(left, right);
            case AExpression.GREATER_THAN: return new GreaterThan(left, right);
            case AExpression.LESS_EQUALS: return new LessEquals(left, right);
            case AExpression.LESS_THAN: return new LessThan(left, right);
            case AExpression.MUL: return new Multiplication(left, right);
            case AExpression.NOT_EQUALS: return new NotEquals(left, right);
            case AExpression.OR: return new Or(left, right);
            case AExpression.SUB: return new Subtraction(left, right);
            default: return null;
        }
    }

    public static boolean isTerminal(AExpression expr, boolean includeIdentifier){
        return (includeIdentifier ? expr.getType() == AExpression.IDENTIFIER : false)
                || expr.getType() == AExpression.DATE
                || expr.getType() == AExpression.BOOLEAN
                || expr.getType() == AExpression.STRING
                || expr.getType() == AExpression.NUMBER;
    }
}
