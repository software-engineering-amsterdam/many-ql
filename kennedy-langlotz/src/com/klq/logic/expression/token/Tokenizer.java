package com.klq.logic.expression.token;

import com.klq.logic.expression.CalculationExpression;

/**
 * Created by Timon on 21.02.2015.
 * Based on Dijkstra's Shunting-yard algorithm.
 */
public class Tokenizer {
    private final char[] expression;
    private final int length;
    private int pos = 0;
    private AToken lastToken;

    public Tokenizer(CalculationExpression calculationExpression) {
        expression = calculationExpression.getContent().toCharArray();
        length = expression.length;
    }

    public AToken nextToken() throws IllegalArgumentException{
        char cur = expression[pos];

        if (cur == OpenParentheses.CHARACTER|| cur == CloseParentheses.CHARACTER)
            return parseParentheses(cur);
        else if (Operator.isOperator(cur))
            return parseOperator(cur);
        else if (Character.isDigit(cur))
            return parseNumber(cur, false);

        return null;
    }

    private AToken parseParentheses(char cur) {
        if (cur == OpenParentheses.CHARACTER) {
            if (lastToken != null && lastToken.getType() == AToken.PARENTHESES_CLOSE)
                throw new IllegalArgumentException(exceptionMessage(cur));
            lastToken = new OpenParentheses();
            pos++;
            return lastToken;
        } else if (cur == CloseParentheses.CHARACTER) {
            if (lastToken != null && lastToken.getType() == AToken.PARENTHESES_OPEN)
                throw new IllegalArgumentException(exceptionMessage(cur));
            lastToken = new CloseParentheses();
            pos++;
            return lastToken;
        }
        throw new IllegalArgumentException(exceptionMessage(cur));
    }

    private AToken parseOperator(char cur){
        if (lastToken != null && (lastToken.getType() == AToken.NUMBER
                || lastToken.getType() == AToken.PARENTHESES_CLOSE)){
            lastToken = new Operator(cur);
            pos++;
            return lastToken;
        } else if ((lastToken == null || lastToken.getType() == AToken.PARENTHESES_OPEN) && cur == '-'){
            pos++;
            return parseNumber(expression[pos], true);
        }
        throw new IllegalArgumentException(exceptionMessage(cur));
    }

    private AToken parseNumber(char cur, boolean isNegative) {
        if (Character.isDigit(cur) && (lastToken == null || lastToken.getType() == AToken.PARENTHESES_OPEN
                || lastToken.getType() == AToken.OPERATOR)){
            String number = Character.toString(cur);
            pos++;
            boolean decimalReached = false;
            while (hasNext() && (Character.isDigit(expression[pos]) || expression[pos] == Number.DECIMAL_MARK)){
                if (decimalReached && expression[pos] == Number.DECIMAL_MARK)
                    throw new IllegalArgumentException(exceptionMessage(expression[pos]));
                if (expression[pos] == Number.DECIMAL_MARK)
                    decimalReached = true;
                number += Character.toString(expression[pos++]);
            }
            double value = Double.valueOf(number);
            lastToken = new Number((isNegative ? value * (-1) : value));
            return lastToken;
        }
        throw new IllegalArgumentException(exceptionMessage(cur));
    }

    public boolean hasNext(){
        return pos < length;
    }

    private String exceptionMessage(char currentChar){
        return "Could not parse character \"" + currentChar + "\" at index " + pos + ".\n" +
                "Last token: " + lastToken.toString() + "\n" +
                "Expression: " + String.valueOf(expression);
    }
}
