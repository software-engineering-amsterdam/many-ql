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

public class ExpressionVisitor implements IExpressionVisitor <ExpressionResult> {
    
    // Logical
    public ExpressionResult visitAndExpression(And andExpression) {
        return null;        
    }
    
    public ExpressionResult visitOrExpression(Or lessExpression ) {         
        return null;             
    }     

    // Unary
    public ExpressionResult visitNotExpression(Not not ) {         
        return null;             
    }   
    
    public ExpressionResult visitNegExpression(Negative negative ) {         
        return null;             
    }   
    
    public ExpressionResult visitPosExpression(Positive positive ) {
        return null;             
    }     

    // Comparison
    public ExpressionResult visitEQExpression(EQ eqExpression ) {         
        return null;             
    }   
    
    public ExpressionResult visitGEExpression(GE geExpression ) {         
        return null;             
    }   
    
    public ExpressionResult visitGreaterExpression(Greater greaterExpression ) {         
        return null;             
    }     
    
    public ExpressionResult visitLEExpression(LE leExpression ) {         
        return null;             
    }
    
    public ExpressionResult visitLessExpression(Less lessExpression ) {        
        return null;            
    }
    
    public ExpressionResult visitNotEqExpression(NotEq notEqExpression ) {         
        return null;             
    }     

    // Numerical
    public ExpressionResult visitAddExpression(Add addExpression ) {         
        return null;             
    }
    
    public ExpressionResult visitSubExpression(Sub subExpression ) {         
        return null;             
    }
    
    public ExpressionResult visitMulExpression(Mul mulExpression ) {         
        return null;             
    }
    
    public ExpressionResult visitDivExpression(Div divExpression ) {         
        return null;             
    }     
}
