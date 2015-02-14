package org.fugazi.evaluator;

import org.fugazi.ast.Expression.*;

//TODO

/**
 * Implementation of the concrete expression Visitor.
 */
public class ExpressionVisitor implements IExpressionVisitor <ExpressionResult> {

    /**
     * =================
     *  Logical
     * ================= 
     */    
    public ExpressionResult visit(AndExpression andExpression) {
        return null;
    }
    
    public ExpressionResult visit(OrExpression lessExpression) {
        return null;
    }

    /**
     * =================
     *  Unary
     * ================= 
     */
    public ExpressionResult visit(NotExpression notExpression) {
        return null;
    }

    public ExpressionResult visit(NegExpression neqExpression) {
        return null;
    }

    public ExpressionResult visit(PosExpression posExpression) {
        return null;
    }

    /**
     * =================
     *  Comparison
     * =================
     */
    public ExpressionResult visit(EQExpression eqExpression) {
        return null;
    }
    
    public ExpressionResult visit(GEExpression geExpression) {
        return null;
    }

    public ExpressionResult visit(GreaterExpression greaterExpression) {
        return null;
    }

    public ExpressionResult visit(LEExpression leExpression) {
        return null;
    }

    public ExpressionResult visit(LessExpression lessExpression) {
        return null;
    }

    public ExpressionResult visit(NotEqExpression notEqExpression) {
        return null;
    }

    /**
     * =================
     *  Numerical
     * =================
     */
    public ExpressionResult visit(AddExpression addExpression) {
        return null;
    }

    public ExpressionResult visit(SubExpression subExpression) {
        return null;
    }

    public ExpressionResult visit(MulExpression mulExpression) {
        return null;
    }

    public ExpressionResult visit(DivExpression divExpression) {
        return null;
    }
}
