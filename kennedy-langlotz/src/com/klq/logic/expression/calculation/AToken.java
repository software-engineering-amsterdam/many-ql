package com.klq.logic.expression.calculation;

/**
 * Created by Timon on 21.02.2015.
 */
public abstract class AToken {
    public static final int NUMBER = 1;
    public static final int OPERATOR = 2;
    public static final int PARENTHESES_OPEN = 3;
    public static final int PARENTHESES_CLOSE = 4;

    protected final int type;

    public AToken(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

    @Override
    public String toString() {
        switch (type){
            case NUMBER: return "NUMBER";
            case OPERATOR: return "OPERATOR";
            case PARENTHESES_OPEN: return "PARENTHESES_OPEN";
            case PARENTHESES_CLOSE: return  "PARENTHESES_CLOSE";
            default: return "Unknown token";
        }
    }
}
