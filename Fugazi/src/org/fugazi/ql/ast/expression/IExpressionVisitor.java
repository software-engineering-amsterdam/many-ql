package org.fugazi.ql.ast.expression;

import org.fugazi.ql.ast.expression.comparison.*;
import org.fugazi.ql.ast.expression.literal.BOOL;
import org.fugazi.ql.ast.expression.literal.ID;
import org.fugazi.ql.ast.expression.literal.INT;
import org.fugazi.ql.ast.expression.literal.STRING;
import org.fugazi.ql.ast.expression.logical.And;
import org.fugazi.ql.ast.expression.logical.Or;
import org.fugazi.ql.ast.expression.numerical.Add;
import org.fugazi.ql.ast.expression.numerical.Div;
import org.fugazi.ql.ast.expression.numerical.Mul;
import org.fugazi.ql.ast.expression.numerical.Sub;
import org.fugazi.ql.ast.expression.unary.Negative;
import org.fugazi.ql.ast.expression.unary.Not;
import org.fugazi.ql.ast.expression.unary.Positive;

public interface IExpressionVisitor<T> {

    // Logical
    public T visitAnd(And _and);
    public T visitOr(Or _less);

    // Unary
    public T visitNot(Not _not);
    public T visitNegative(Negative _negative);
    public T visitPositive(Positive _positive);

    // Comparison
    public T visitEQ(EQ _eq);
    public T visitGE(GE _ge);
    public T visitGreater(Greater _greater);
    public T visitLE(LE _le);
    public T visitLesser(Less _less);
    public T visitNotEq(NotEq _notEq);

    // Numerical
    public T visitAdd(Add _add);
    public T visitSub(Sub _sub);
    public T visitMul(Mul _mul);
    public T visitDiv(Div _div);

    // Literals
    public T visitID(ID _id);
    public T visitINT(INT _int);
    public T visitSTRING(STRING _string);
    public T visitBOOL(BOOL _bool);
}
