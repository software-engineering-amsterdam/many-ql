package com.klq.logic.expression;

import com.klq.logic.IKLQItem;

import java.lang.*;

/**
 * Created by Timon on 17.02.2015.
 */
public abstract class AExpression implements Comparable, IKLQItem{
    public static final int ADD = -4;
    public static final int SUB = -3;
    public static final int MUL = -2;
    public static final int DIV = -1;
    public static final int AND = 0;
    public static final int OR = 1;
    public static final int EQUALS = 2;
    public static final int NOT_EQUALS = 3;
    public static final int GREATER_THAN = 4;
    public static final int GREATER_EQUALS = 5;
    public static final int LESS_EQUALS = 6;
    public static final int LESS_THAN = 7;
    public static final int NUMBER = 8;
    public static final int DATE = 9;
    public static final int STRING = 10;
    public static final int IDENTIFIER = 11;
    public static final int BOOLEAN = 12;

    public static final int UNCOMPARABLE = Integer.MAX_VALUE;

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

    @Override
    public String toString() {
        return left + " - " + this.getClass().getSimpleName() + " - " + right;
    }

    public AExpression getLeft() {
        return left;
    }

    public AExpression getRight() {
        return right;
    }
}
