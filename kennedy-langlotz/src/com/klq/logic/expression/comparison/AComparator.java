package com.klq.logic.expression.comparison;

/**
 * Created by Timon on 22.02.2015.
 */
public abstract class AComparator{
    public static final int NUMBER = 1;
    public static final int DATE = 2;
    public static final int STRING = 3;
    //public static final int QUESTION_ID = 4;

    protected static final int UNCOMPARABLE = 42;

    protected final int type;
    protected final String content;

    public AComparator(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public abstract int compareTo(AComparator o);
}
