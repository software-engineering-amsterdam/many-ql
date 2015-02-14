package org.fugazi.ast.Expression;

import org.fugazi.ast.Expression.comparison.*;
import org.fugazi.ast.Expression.logical.AndExpression;
import org.fugazi.ast.Expression.logical.OrExpression;
import org.fugazi.ast.Expression.numerical.AddExpression;
import org.fugazi.ast.Expression.numerical.DivExpression;
import org.fugazi.ast.Expression.numerical.MulExpression;
import org.fugazi.ast.Expression.numerical.SubExpression;
import org.fugazi.ast.Expression.unary.NegExpression;
import org.fugazi.ast.Expression.unary.NotExpression;
import org.fugazi.ast.Expression.unary.PosExpression;

/**
 * Generic Visitor interface for Expressions.
 * @param <T>
 */
public interface IExpressionVisitor<T> {

    // Logical
    public T visit(AndExpression andExpression);
    public T visit(OrExpression lessExpression);
    
    // Unary
    public T visit(NotExpression notExpression);
    public T visit(NegExpression negExpression);
    public T visit(PosExpression notExpression);

    // Comparison
    public T visit(EQExpression eqExpression);
    public T visit(GEExpression geExpression);
    public T visit(GreaterExpression greaterExpression);
    public T visit(LEExpression leExpression);
    public T visit(LessExpression lessExpression);
    public T visit(NotEqExpression notEqExpression);
    
    // Numerical
    public T visit(AddExpression addExpression);
    public T visit(SubExpression subExpression);
    public T visit(MulExpression mulExpression);
    public T visit(DivExpression divExpression);
}