package org.fugazi.evaluator;

import org.fugazi.ast.expression.Binary;
import org.fugazi.ast.expression.Expression;
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

import java.util.Map;

public class ExpressionVisitor implements IExpressionVisitor <ExpressionValue> {
    
    private final ValueStorage values = new ValueStorage();

    public ExpressionVisitor() {
        
    }

    public void saveValue(String _id, ExpressionValue _val) {
        values.saveValue(_id, _val);
    }
    
    public ExpressionValue getValue(String _id) {
        return values.getValue(_id);
    }

    // Logical
    public ExpressionValue visitAnd(And and) {
        return null;        
    }
    
    public ExpressionValue visitOr(Or less) {
        return null;             
    }     

    // Unary
    public ExpressionValue visitNot(Not not) {
        return null;             
    }   
    
    public ExpressionValue visitNegative(Negative negative) {
        return null;             
    }   
    
    public ExpressionValue visitPositive(Positive positive) {
        return null;             
    }     

    // Comparison
    public ExpressionValue visitEQ(EQ eq) {
        return null;             
    }   
    
    public ExpressionValue visitGE(GE ge) {
        return null;             
    }   
    
    public ExpressionValue visitGreater(Greater greater) {
        return null;             
    }     
    
    public ExpressionValue visitLE(LE le) {
        return null;             
    }
    
    public ExpressionValue visitLesser(Less less) {
        return null;            
    }
    
    public ExpressionValue visitNotEq(NotEq notEq) {
        return null;             
    }     

    // Numerical
    public ExpressionValue visitAdd(Add add) {
        return null;             
    }
    
    public ExpressionValue visitSub(Sub sub) {
        return null;             
    }
    
    public ExpressionValue visitMul(Mul mul) {
        return null;             
    }
    
    public ExpressionValue visitDiv(Div div) {
        return null;             
    }     
}
