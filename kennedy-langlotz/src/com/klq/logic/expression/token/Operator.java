package com.klq.logic.expression.token;

/**
 * Created by Timon on 21.02.2015.
 */
public class Operator extends AToken {
    private final OperatorType operatorType;
    private final short precedence;

    public Operator(char operator) {
        super(AToken.OPERATOR);
        switch (operator){
            case '*':
                operatorType = OperatorType.MUL;
                precedence = 2;
                break;
            case '/':
                operatorType = OperatorType.DIV;
                precedence = 2;
                break;
            case '+':
                operatorType = OperatorType.ADD;
                precedence = 1;
                break;
            case '-':
                operatorType = OperatorType.SUB;
                precedence = 1;
                break;
            default:
                throw new IllegalArgumentException("Not an operator: \"" + operator + "\"");
        }
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    public static boolean isOperator(char cur){
        return cur == '+' || cur == '-' || cur == '*' || cur == '/';
    }

    public short getPrecedence() {
        return precedence;
    }

    public enum OperatorType {
        MUL, DIV, ADD, SUB
    }
}
