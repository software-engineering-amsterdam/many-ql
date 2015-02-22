package com.klq.logic.expression.comparison;

/**
 * Created by Timon on 22.02.2015.
 */
public enum ComparatorOperation {
    GREATER (">"), GREATER_THAN (">="), LESS ("<"), LESS_THAN ("<=");

    private final String operator;

    private ComparatorOperation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static String regex(){
        return GREATER.operator + "|" + GREATER_THAN.operator + "|" +
                LESS.operator + "|" + LESS_THAN.operator;
    }
}
