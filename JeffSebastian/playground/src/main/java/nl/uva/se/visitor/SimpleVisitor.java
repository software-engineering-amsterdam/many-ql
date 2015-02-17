package nl.uva.se.visitor;

import nl.uva.se.ast.expression.LogicalOperators.And;
import nl.uva.se.ast.expression.LogicalOperators.Equal;
import nl.uva.se.ast.expression.LogicalOperators.GreaterOrEqual;
import nl.uva.se.ast.expression.LogicalOperators.GreaterThen;
import nl.uva.se.ast.expression.LogicalOperators.LessOrEqual;
import nl.uva.se.ast.expression.LogicalOperators.LessThen;
import nl.uva.se.ast.expression.LogicalOperators.Not;
import nl.uva.se.ast.expression.LogicalOperators.NotEqual;
import nl.uva.se.ast.expression.LogicalOperators.Or;
import nl.uva.se.ast.expression.MathematicalOperators.Addition;
import nl.uva.se.ast.expression.MathematicalOperators.Divide;
import nl.uva.se.ast.expression.MathematicalOperators.Modulo;
import nl.uva.se.ast.expression.MathematicalOperators.Multiply;
import nl.uva.se.ast.expression.MathematicalOperators.Power;
import nl.uva.se.ast.expression.MathematicalOperators.Substraction;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.literal.BooleanLiteral;
import nl.uva.se.ast.literal.DecimalLiteral;
import nl.uva.se.ast.literal.IntegerLiteral;
import nl.uva.se.ast.literal.StringLiteral;
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
	public void visit(Addition plus) {
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
	public void visit(Substraction minus) {
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

	@Override
	public void visit(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DecimalLiteral decimalLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IntegerLiteral integerLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		
	}

}
