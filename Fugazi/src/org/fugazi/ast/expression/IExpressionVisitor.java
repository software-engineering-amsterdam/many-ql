package org.fugazi.ast.expression;

import org.fugazi.ast.expression.comparison.*;
import org.fugazi.ast.expression.literal.*;
import org.fugazi.ast.expression.logical.*;
import org.fugazi.ast.expression.numerical.*;
import org.fugazi.ast.expression.unary.*;

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
    public T visitBOOL(BOOL bool);
}
