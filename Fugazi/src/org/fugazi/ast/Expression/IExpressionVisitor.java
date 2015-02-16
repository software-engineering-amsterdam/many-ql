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
    public T visitAnd(And andExpression);
    public T visitOr(Or lessExpression);

    // Unary
    public T visitNot(Not not);
    public T visitNegative(Negative negative);
    public T visitPositive(Positive positive);

    // Comparison
    public T visitEQ(EQ eqExpression);
    public T visitGE(GE geExpression);
    public T visitGreater(Greater greaterExpression);
    public T visitLE(LE leExpression);
    public T visitLesser(Less lessExpression);
    public T visitNotEq(NotEq notEqExpression);

    // Numerical
    public T visitAdd(Add addExpression);
    public T visitSub(Sub subExpression);
    public T visitMul(Mul mulExpression);
    public T visitDiv(Div divExpression);
}
