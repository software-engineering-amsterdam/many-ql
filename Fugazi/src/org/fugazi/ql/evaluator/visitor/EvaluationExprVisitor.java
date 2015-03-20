package org.fugazi.ql.evaluator.visitor;

import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.numerical.Add;
import org.fugazi.ql.ast.expression.numerical.Div;
import org.fugazi.ql.ast.expression.numerical.Mul;
import org.fugazi.ql.ast.expression.numerical.Sub;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;
import org.fugazi.ql.evaluator.expression_value.*;

public class EvaluationExprVisitor implements IExpressionVisitor <ExpressionValue> {

    private final ValueStorage values;
    
    public EvaluationExprVisitor(ValueStorage _values) {
        this.values = _values;
    }

    /**
     * Logical
     */
    public ExpressionValue visitAnd(And _and) {
        ExpressionValue left = _and.getLeft().accept(this);
        ExpressionValue right = _and.getRight().accept(this);

        return left.and(right);
    }
    
    public ExpressionValue visitOr(Or _or) {
        ExpressionValue left = _or.getLeft().accept(this);
        ExpressionValue right = _or.getRight().accept(this);

        return left.or(right);
    }

    /**
     * Unary
     */
    public ExpressionValue visitNot(Not _not) {
        ExpressionValue expression = _not.getExpr().accept(this);
        return expression.not();
    }   
    
    public ExpressionValue visitNegative(Negative _negative) {
        ExpressionValue expression = _negative.getExpr().accept(this);
        return expression.negative();
    }   
    
    public ExpressionValue visitPositive(Positive _positive) {
        ExpressionValue expression = _positive.getExpr().accept(this);
        return expression.positive();
    }

    /**
     * Comparison
     */
    public ExpressionValue visitEQ(EQ _eq) {
        ExpressionValue left = _eq.getLeft().accept(this);
        ExpressionValue right = _eq.getRight().accept(this);

        return left.equal(right);
    }

    public ExpressionValue visitNotEq(NotEq _notEq) {
        ExpressionValue left = _notEq.getLeft().accept(this);
        ExpressionValue right = _notEq.getRight().accept(this);

        return left.notEqual(right);
    }

    public ExpressionValue visitGreater(Greater _greater) {
        ExpressionValue left = _greater.getLeft().accept(this);
        ExpressionValue right = _greater.getRight().accept(this);

        return left.greater(right);
    }

    public ExpressionValue visitLesser(Less _less) {
        ExpressionValue left = _less.getLeft().accept(this);
        ExpressionValue right = _less.getRight().accept(this);

        return left.less(right);
    }
    
    public ExpressionValue visitGE(GE _ge) {
        ExpressionValue left = _ge.getLeft().accept(this);
        ExpressionValue right = _ge.getRight().accept(this);

        return left.greaterEqual(right);
    }   

    public ExpressionValue visitLE(LE _le) {
        ExpressionValue left = _le.getLeft().accept(this);
        ExpressionValue right = _le.getRight().accept(this);

        return left.lessEqual(right);
    }

    /**
     * Numerical
     */
    public ExpressionValue visitAdd(Add _add) {
        ExpressionValue left = _add.getLeft().accept(this);
    	ExpressionValue right = _add.getRight().accept(this);

    	return left.add(right);
    }
    
    public ExpressionValue visitSub(Sub _sub) {
        ExpressionValue left = _sub.getLeft().accept(this);
        ExpressionValue right = _sub.getRight().accept(this);

        return left.sub(right);
    }
    
    public ExpressionValue visitMul(Mul _mul) {
        ExpressionValue left = _mul.getLeft().accept(this);
        ExpressionValue right = _mul.getRight().accept(this);

        return left.mul(right);
    }
    
    public ExpressionValue visitDiv(Div _div) {
        ExpressionValue left = _div.getLeft().accept(this);
        ExpressionValue right = _div.getRight().accept(this);

        return left.div(right);
    }

    /**
     * Literals
     */
    public ExpressionValue visitID(ID _id) {
        return this.values.getExpressionValue(_id.getName());
    }
    
    public ExpressionValue visitINT(INT _int) {
        return new IntValue(_int.getValue());
    }

    public ExpressionValue visitSTRING(STRING _string) {
        return new StringValue(_string.getValue());
    }

    public ExpressionValue visitBOOL(BOOL _bool) {
        return new BoolValue(_bool.getValue());
    }
}