package com.klq.logic.expression.calculation;

/**
 * Created by Timon on 21.02.2015.
 */
public class CloseParentheses extends AToken{
    public static final char CHARACTER = ')';
    public CloseParentheses() {
        super(AToken.PARENTHESES_CLOSE);
    }
}
