package org.fugazi.ast.expression;

import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.expression.literal.INT;
import org.fugazi.ast.expression.literal.STRING;
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
    public T visitAnd(And and);
    public T visitOr(Or less);

    // Unary
    public T visitNot(Not not);
    public T visitNegative(Negative negative);
    public T visitPositive(Positive positive);

    // Comparison
    public T visitEQ(EQ eq);
    public T visitGE(GE ge);
    public T visitGreater(Greater greater);
    public T visitLE(LE le);
    public T visitLesser(Less less);
    public T visitNotEq(NotEq notEq);

    // Numerical
    public T visitAdd(Add add);
    public T visitSub(Sub sub);
    public T visitMul(Mul mul);
    public T visitDiv(Div div);

    // Literals
    public T visitID(ID id);
    public T visitINT(INT INT);
    public T visitSTRING(STRING string);
}
