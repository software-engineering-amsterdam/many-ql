package org.fugazi.ast.expression;

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

public interface IExpressionVisitor<T> {

    // Logical
    public T visitAndExpression(And andExpression);
    public T visitOrExpression(Or lessExpression);

    // Unary
    public T visitNotExpression(Not not);
    public T visitNegExpression(Negative negative);
    public T visitPosExpression(Positive positive);

    // Comparison
    public T visitEQExpression(EQ eqExpression);
    public T visitGEExpression(GE geExpression);
    public T visitGreaterExpression(Greater greaterExpression);
    public T visitLEExpression(LE leExpression);
    public T visitLessExpression(Less lessExpression);
    public T visitNotEqExpression(NotEq notEqExpression);

    // Numerical
    public T visitAddExpression(Add addExpression);
    public T visitSubExpression(Sub subExpression);
    public T visitMulExpression(Mul mulExpression);
    public T visitDivExpression(Div divExpression);
}
