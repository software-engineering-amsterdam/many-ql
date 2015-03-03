package uva.sc.ast;

import uva.sc.atom.BooleanAtom;
import uva.sc.atom.ID;
import uva.sc.atom.Literal;
import uva.sc.atom.NumberAtom;
import uva.sc.atom.StringAtom;
import uva.sc.logic.*;
import uva.sc.logic.binaryExpressions.*;
import uva.sc.logic.unaryExpressions.*;
import uva.sc.types.Boolean;
import uva.sc.types.Number;
import uva.sc.types.String;
import uva.sc.types.Unidentified;

public interface INodeVisitor<T> {

	public T visit(Form questionare);

	public T visit(Literal literal);

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
	
	public T visit(Power pow);
	
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
