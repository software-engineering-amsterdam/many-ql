package nl.uva.se.visitor;

import nl.uva.se.ast.expression.And;
import nl.uva.se.ast.expression.Divide;
import nl.uva.se.ast.expression.Equal;
import nl.uva.se.ast.expression.GreaterOrEqual;
import nl.uva.se.ast.expression.GreaterThen;
import nl.uva.se.ast.expression.LessOrEqual;
import nl.uva.se.ast.expression.LessThen;
import nl.uva.se.ast.expression.Minus;
import nl.uva.se.ast.expression.Modulo;
import nl.uva.se.ast.expression.Multiply;
import nl.uva.se.ast.expression.Not;
import nl.uva.se.ast.expression.NotEqual;
import nl.uva.se.ast.expression.Or;
import nl.uva.se.ast.expression.Plus;
import nl.uva.se.ast.expression.Power;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;

public class SimpleVisitor implements Visitor {

	@Override
	public void visit(Form form) {
		System.out.println(form.getId());
	}

	@Override
	public void visit(Question question) {
		System.out.println(question.getQuestion());
		
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		System.out.println(calculatedQuestion.getQuestion());
		
	}

	@Override
	public void visit(Condition condition) {
		System.out.println("condition");
		
	}

	@Override
	public void visit(Not not) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NotEqual notEqual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Or or) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Plus plus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Power power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Multiply multiply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Modulo modulo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Minus minus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LessThen lessThen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LessOrEqual lessOrEqual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GreaterThen greaterThen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GreaterOrEqual greaterOrEqual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Equal equal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Divide divide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(And and) {
		// TODO Auto-generated method stub
		
	}

}
