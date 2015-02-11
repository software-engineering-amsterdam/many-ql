package org.fugazi.ast.Expression;

/**
 * Generic Visitor class for Expressions.
 * @param <T>
 */
public interface ExpressionVisitor<T> {

    // Logical
    public T visit(AndExpression andExpression);
    public T visit(OrExpression lessExpression);
    public T visit(NotExpression notExpression);
    
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