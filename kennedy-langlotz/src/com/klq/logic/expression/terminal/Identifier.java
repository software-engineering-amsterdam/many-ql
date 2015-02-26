package com.klq.logic.expression.terminal;

import com.klq.logic.expression.AExpression;

import java.lang.*;
import java.lang.String;

/**
 * Created by Timon on 23.02.2015.
 */
public class Identifier extends AExpression {
    private final String content;
    private AExpression assignedVariable;

    public Identifier(String content) {
        super(null, null, AExpression.IDENTIFIER);
        this.content = content;
    }

    @Override
    public AExpression evaluate() {
        if (assignedVariable != null)
            return assignedVariable;
        return this;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void assignVariable(AExpression variable){
        if (variable != null) {
            this.assignedVariable = variable;
            fireValueChangedEvent();
        }
    }
}
