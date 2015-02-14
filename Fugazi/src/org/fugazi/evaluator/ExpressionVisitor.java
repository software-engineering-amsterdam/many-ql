package org.fugazi.evaluator;


import org.fugazi.ast.ASTNode.ASTNode;
import org.fugazi.ast.Expression.*;

/**
 * Implementation of the expression Visitor.
 */
public class ExpressionVisitor implements IExpressionVisitor <ASTNode> {
    // TODO: Not ASTNode? -> (<abstract>Result) maybe

    /**
     * =================
     *  Logical
     * ================= 
     */    
    public ASTNode visit(AndExpression andExpression) {
        return null;
    }
    
    public ASTNode visit(OrExpression lessExpression) {
        return null;
    }
    
    public ASTNode visit(NotExpression notExpression) {
        return null;
    }

    /**
     * =================
     *  Comparison
     * =================
     */
    public ASTNode visit(EQExpression eqExpression) {
        return null;
    }
    
    public ASTNode visit(GEExpression geExpression) {
        return null;
    }

    public ASTNode visit(GreaterExpression greaterExpression) {
        return null;
    }

    public ASTNode visit(LEExpression leExpression) {
        return null;
    }

    public ASTNode visit(LessExpression lessExpression) {
        return null;
    }

    public ASTNode visit(NotEqExpression notEqExpression) {
        return null;
    }

    /**
     * =================
     *  Numerical
     * =================
     */
    public ASTNode visit(AddExpression addExpression) {
        return null;
    }

    public ASTNode visit(SubExpression subExpression) {
        return null;
    }

    public ASTNode visit(MulExpression mulExpression) {
        return null;
    }

    public ASTNode visit(DivExpression divExpression) {
        return null;
    }
}
