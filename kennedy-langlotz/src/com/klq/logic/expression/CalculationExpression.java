package com.klq.logic.expression;

/**
 * Created by Timon on 17.02.2015.
 */
public class CalculationExpression extends AExpression {

    public CalculationExpression(String content) {
        super(content);
    }

    @Override
    public AExpression evaluate() {
        return null;
    }

    @Override
    public boolean isValidExpression() {
        return content.matches("[0-9]*(.[0-9]*)?(+|-|*|/)[0-9]*(.[0-9]*)?");
    }
}
