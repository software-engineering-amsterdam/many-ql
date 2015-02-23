package com.klq.logic.expression;

import java.lang.*;

/**
 * Created by Timon on 17.02.2015.
 */
public abstract class AExpression implements Comparable{
    protected static final int ADD = -4;
    protected static final int SUB = -3;
    protected static final int MUL = -2;
    protected static final int DIV = -1;
    protected static final int AND = 0;
    protected static final int OR = 1;
    protected static final int EQUALS = 2;
    protected static final int NOT_EQUALS = 3;
    protected static final int GREATER_THAN = 4;
    protected static final int GREATER_EQUALS = 5;
    protected static final int LESS_EQUALS = 6;
    protected static final int LESS_THAN = 7;
    protected static final int NUMBER = 8;
    protected static final int DATE = 9;
    protected static final int STRING = 10;
    protected static final int IDENTIFIER = 11;
    protected static final int BOOLEAN = 12;

    protected static final int UNCOMPARABLE = 42;

    protected final AExpression left;
    protected final AExpression right;
    protected final int type;

    public AExpression(AExpression left, AExpression right, int type) {
        this.left = left;
        this.right = right;
        this.type = type;
    }

    public abstract AExpression evaluate();

    public java.lang.String getContent(){
        return null;
    }

    public int getType() {
        return type;
    }

    @Override
    public int compareTo(Object o) {
        return UNCOMPARABLE;
    }
}
