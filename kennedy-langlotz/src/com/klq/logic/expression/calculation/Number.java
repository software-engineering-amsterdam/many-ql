package com.klq.logic.expression.calculation;

/**
 * Created by Timon on 21.02.2015.
 */
public class Number extends AToken {
    public static final char DECIMAL_MARK = '.';
    private final String value;

    public Number(double value) {
        super(AToken.NUMBER);
        this.value = String.valueOf(value).replaceAll(".(0)+$", "");
    }

    public String getValue() {
        return value;
    }
}
