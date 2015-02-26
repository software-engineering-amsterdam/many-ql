package com.klq.logic.expression;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.operator.bool.*;
import com.klq.logic.expression.operator.math.Addition;
import com.klq.logic.expression.operator.math.Division;
import com.klq.logic.expression.operator.math.Multiplication;
import com.klq.logic.expression.operator.math.Subtraction;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringPropertyBase;

import java.lang.*;

/**
 * Created by Timon on 17.02.2015.
 */
public abstract class AExpression extends StringPropertyBase implements Comparable, IKLQItem{
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

    @Override
    public String get() {
        return (evaluate().getContent() != null ?
                evaluate().getContent() : "---");
    }

    @Override
    public String getName() {
        return "Expression?";
    }

    @Override
    public Object getBean() {
        return this;
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
        return (left != null ? left : "()") + " - "
                + this.getClass().getSimpleName() + " - "
                + (right != null ? right : "()");
    }

    public AExpression getLeft() {
        return left;
    }

    public AExpression getRight() {
        return right;
    }

    public boolean isTerminal(boolean includeIdentifier){
        return type == DATE || type == NUMBER || type == STRING
                || (includeIdentifier ? type == IDENTIFIER : false);
    }

    /**
     * Copies an AExpression.
     *
     * @param current   The expression to copy.
     * @param newLeft   The new left child, or null if the original should be kept.
     * @param newRight  The new right child, or null if the original should be kept.
     * @return          A new instance of the given expression.
     */
    public static AExpression copyExpressionFrom(AExpression current, AExpression newLeft, AExpression newRight){
        AExpression left = (newLeft != null ? newLeft : current.getLeft());
        AExpression right = (newRight != null ? newRight : current.getRight());
        switch (current.getType()){
            case AExpression.ADD: return new Addition(left, right);
            case AExpression.AND: return new And(left, right);
            case AExpression.DIV: return new Division(left, right);
            case AExpression.EQUALS: return new Equals(left, right);
            case AExpression.GREATER_EQUALS: return new GreaterEquals(left, right);
            case AExpression.GREATER_THAN: return new GreaterThan(left, right);
            case AExpression.LESS_EQUALS: return new LessEquals(left, right);
            case AExpression.LESS_THAN: return new LessThan(left, right);
            case AExpression.MUL: return new Multiplication(left, right);
            case AExpression.NOT_EQUALS: return new NotEquals(left, right);
            case AExpression.OR: return new Or(left, right);
            case AExpression.SUB: return new Subtraction(left, right);
            default: return null;
        }
    }
}
