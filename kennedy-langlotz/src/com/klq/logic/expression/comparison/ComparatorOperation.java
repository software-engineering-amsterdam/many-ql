package com.klq.logic.expression.comparison;

/**
 * Created by Timon on 22.02.2015.
 */
public enum ComparatorOperation {
    GREATER_EQUAL(">="), GREATER_THAN (">"), LESS_THAN("<"), LESS_EQUAL("<="), EQUAL ("=="), NOT_EQUAL ("!=");

    private final String operator;

    private ComparatorOperation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static String regex(){
        return GREATER_EQUAL.operator + "|" + GREATER_THAN.operator + "|" +
                LESS_THAN.operator + "|" + LESS_EQUAL.operator + "|" +
                EQUAL.operator + "|" + NOT_EQUAL;
    }
}
