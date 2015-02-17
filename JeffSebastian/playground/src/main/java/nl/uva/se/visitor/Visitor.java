package nl.uva.se.visitor;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.ast.expression.*;

public interface Visitor {
	
	public void visit(Form form);
	public void visit(Question question);
	public void visit(CalculatedQuestion calculatedQuestion);
	public void visit(Condition condition);
	public void visit(Not not);
	public void visit(NotEqual notEqual);
	public void visit(Or or);
	public void visit(Plus plus);
	public void visit(Power power);
	public void visit(Multiply multiply);
	public void visit(Modulo modulo);
	public void visit(Minus minus);
	public void visit(LessThen lessThen);
	public void visit(LessOrEqual lessOrEqual);
	public void visit(GreaterThen greaterThen);
	public void visit(GreaterOrEqual greaterOrEqual);
	public void visit(Equal equal);
	public void visit(Divide divide);
	public void visit(And and);
}
