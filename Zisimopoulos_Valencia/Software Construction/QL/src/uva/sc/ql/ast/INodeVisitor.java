package uva.sc.ql.ast;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.logic.*;
import uva.sc.ql.logic.binaryExpressions.*;
import uva.sc.ql.logic.unaryExpressions.*;
import uva.sc.ql.types.Boolean;
import uva.sc.ql.types.Number;
import uva.sc.ql.types.String;
import uva.sc.ql.types.Unidentified;

public interface INodeVisitor<T> {

	public T visit(Form questionare);

	public T visit(Question question);

	public T visit(If_Statement if_statement);

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

	public T visit(Boolean bool);

	public T visit(String str);

	public T visit(BooleanAtom bool);

	public T visit(NumberAtom doub);

	public T visit(StringAtom str);

	public T visit(Number number);

	public T visit(Unidentified unidentified);
}
