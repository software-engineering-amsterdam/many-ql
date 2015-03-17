package uva.sc.ql.ast;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.expression.binaryExpressions.Addition;
import uva.sc.ql.expression.binaryExpressions.And;
import uva.sc.ql.expression.binaryExpressions.Division;
import uva.sc.ql.expression.binaryExpressions.Equals;
import uva.sc.ql.expression.binaryExpressions.GreaterThan;
import uva.sc.ql.expression.binaryExpressions.GreaterThanEquals;
import uva.sc.ql.expression.binaryExpressions.LesserThan;
import uva.sc.ql.expression.binaryExpressions.LesserThanEquals;
import uva.sc.ql.expression.binaryExpressions.Modulus;
import uva.sc.ql.expression.binaryExpressions.Multiplication;
import uva.sc.ql.expression.binaryExpressions.NotEquals;
import uva.sc.ql.expression.binaryExpressions.Or;
import uva.sc.ql.expression.binaryExpressions.Substraction;
import uva.sc.ql.expression.unaryExpressions.Minus;
import uva.sc.ql.expression.unaryExpressions.Not;

public interface IQLExpressionNodeVisitor<T> {

    public T visit(ID id);

    public T visit(Addition addition);

    public T visit(And and);

    public T visit(Division division);

    public T visit(Equals equals);

    public T visit(GreaterThan greaterThan);

    public T visit(GreaterThanEquals greaterThanEquals);

    public T visit(LesserThan lesserThan);

    public T visit(LesserThanEquals lesserThanEquals);

    public T visit(Modulus mod);

    public T visit(Multiplication mult);

    public T visit(NotEquals notEquals);

    public T visit(Or or);

    public T visit(Substraction sub);

    public T visit(Minus minus);

    public T visit(Not not);

    public T visit(BooleanAtom bool);

    public T visit(NumberAtom doub);

    public T visit(StringAtom str);

}
