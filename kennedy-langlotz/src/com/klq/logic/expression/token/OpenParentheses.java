package com.klq.logic.expression.token;

/**
 * Created by Timon on 21.02.2015.
 */
public class OpenParentheses extends AToken{
    public static final char CHARACTER = '(';

    public OpenParentheses() {
        super(AToken.PARENTHESES_OPEN);
    }
}
