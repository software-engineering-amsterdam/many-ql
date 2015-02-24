package org.fugazi.evaluator.visitor;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.BOOL;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.INT;
import org.fugazi.ast.expression.literal.STRING;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.Add;
import org.fugazi.ast.expression.numerical.Div;
import org.fugazi.ast.expression.numerical.Mul;
import org.fugazi.ast.expression.numerical.Sub;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;
import org.fugazi.evaluator.expression_value.*;

public class EvaluationExprVisitor implements IExpressionVisitor <ExpressionValue> {

    private final ValueStorage values;
    
    public EvaluationExprVisitor(ValueStorage _values) {
        this.values = _values;
    }

    /**
     * Logical
     */
    public ExpressionValue visitAnd(And and) {
        ExpressionValue left = and.getLeft().accept(this);
        ExpressionValue right = and.getRight().accept(this);

        return left.and(right);
    }
    
    public ExpressionValue visitOr(Or or) {
        ExpressionValue left = or.getLeft().accept(this);
        ExpressionValue right = or.getRight().accept(this);

        return left.or(right);
    }

    /**
     * Unary
     */
    public ExpressionValue visitNot(Not not) {
        ExpressionValue expression = not.getExpr().accept(this);
        return expression.not();
    }   
    
    public ExpressionValue visitNegative(Negative negative) {
        ExpressionValue expression = negative.getExpr().accept(this);
        return expression.negative();
    }   
    
    public ExpressionValue visitPositive(Positive positive) {
        ExpressionValue expression = positive.getExpr().accept(this);
        return expression.positive();
    }

    /**
     * Comparison
     */
    public ExpressionValue visitEQ(EQ eq) {
        ExpressionValue left = eq.getLeft().accept(this);
        ExpressionValue right = eq.getRight().accept(this);

        return left.equal(right);
    }

    public ExpressionValue visitNotEq(NotEq notEq) {
        ExpressionValue left = notEq.getLeft().accept(this);
        ExpressionValue right = notEq.getRight().accept(this);

        return left.notEqual(right);
    }

    public ExpressionValue visitGreater(Greater greater) {
        ExpressionValue left = greater.getLeft().accept(this);
        ExpressionValue right = greater.getRight().accept(this);

        return left.greater(right);
    }

    public ExpressionValue visitLesser(Less less) {
        ExpressionValue left = less.getLeft().accept(this);
        ExpressionValue right = less.getRight().accept(this);

        return left.less(right);
    }
    
    public ExpressionValue visitGE(GE ge) {
        ExpressionValue left = ge.getLeft().accept(this);
        ExpressionValue right = ge.getRight().accept(this);

        return left.greaterEqual(right);
    }   

    public ExpressionValue visitLE(LE le) {
        ExpressionValue left = le.getLeft().accept(this);
        ExpressionValue right = le.getRight().accept(this);

        return left.lessEqual(right);
    }

    /**
     * Numerical
     */
    public ExpressionValue visitAdd(Add add) {
        ExpressionValue left = add.getLeft().accept(this);
    	ExpressionValue right = add.getRight().accept(this);

    	return left.add(right);
    }
    
    public ExpressionValue visitSub(Sub sub) {
        ExpressionValue left = sub.getLeft().accept(this);
        ExpressionValue right = sub.getRight().accept(this);

        return left.sub(right);
    }
    
    public ExpressionValue visitMul(Mul mul) {
        ExpressionValue left = mul.getLeft().accept(this);
        ExpressionValue right = mul.getRight().accept(this);

        return left.mul(right);
    }
    
    public ExpressionValue visitDiv(Div div) {
        ExpressionValue left = div.getLeft().accept(this);
        ExpressionValue right = div.getRight().accept(this);

        return left.div(right);
    }

    /**
     * Literals
     */
    public ExpressionValue visitID(ID id) {
        return values.containsKey(id.getName()) ? values.get(id.getName()) : new UndefinedValue();
    }
    
    public ExpressionValue visitINT(INT number) {
        return new IntValue(number.getValue());
    }

    public ExpressionValue visitSTRING(STRING string) {
        return new StringValue(string.getValue());
    }

    public ExpressionValue visitBOOL(BOOL bool) {
        return new BoolValue(bool.getValue());
    }
}
