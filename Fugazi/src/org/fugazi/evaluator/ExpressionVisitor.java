package org.fugazi.evaluator;

import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.logical.And;
import org.fugazi.ast.expression.logical.Or;
import org.fugazi.ast.expression.numerical.Add;
import org.fugazi.ast.expression.numerical.Div;
import org.fugazi.ast.expression.numerical.Mul;
import org.fugazi.ast.expression.numerical.Sub;
import org.fugazi.ast.expression.unary.Negative;
import org.fugazi.ast.expression.unary.Not;
import org.fugazi.ast.expression.unary.Positive;

import java.util.HashMap;

public class ExpressionVisitor implements IExpressionVisitor <ExpressionResult> {
    private final HashMap<String, ExpressionResult> values;

    public ExpressionVisitor() {
        values = new HashMap<String, ExpressionResult>();
    }

    public void storeValue(String identifier, ExpressionResult result) {
        values.put(identifier, result);
    }

    // Logical
    public ExpressionResult visitAnd(And andExpression) {
        return null;        
    }
    
    public ExpressionResult visitOr(Or lessExpression) {
        return null;             
    }     

    // Unary
    public ExpressionResult visitNot(Not not) {
        return null;             
    }   
    
    public ExpressionResult visitNegative(Negative negative) {
        return null;             
    }   
    
    public ExpressionResult visitPositive(Positive positive) {
        return null;             
    }     

    // Comparison
    public ExpressionResult visitEQ(EQ eqExpression) {
        return null;             
    }   
    
    public ExpressionResult visitGE(GE geExpression) {
        return null;             
    }   
    
    public ExpressionResult visitGreater(Greater greaterExpression) {
        return null;             
    }     
    
    public ExpressionResult visitLE(LE leExpression) {
        return null;             
    }
    
    public ExpressionResult visitLesser(Less lessExpression) {
        return null;            
    }
    
    public ExpressionResult visitNotEq(NotEq notEqExpression) {
        return null;             
    }     

    // Numerical
    public ExpressionResult visitAdd(Add addExpression) {
        return null;             
    }
    
    public ExpressionResult visitSub(Sub subExpression) {
        return null;             
    }
    
    public ExpressionResult visitMul(Mul mulExpression) {
        return null;             
    }
    
    public ExpressionResult visitDiv(Div divExpression) {
        return null;             
    }     
}
