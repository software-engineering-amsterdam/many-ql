package nl.uva.se.interpreter;

import nl.uva.se.ast.expression.arithmetical.Addition;
import nl.uva.se.ast.expression.arithmetical.Divide;
import nl.uva.se.ast.expression.arithmetical.Modulo;
import nl.uva.se.ast.expression.arithmetical.Multiply;
import nl.uva.se.ast.expression.arithmetical.Negative;
import nl.uva.se.ast.expression.arithmetical.Positive;
import nl.uva.se.ast.expression.arithmetical.Power;
import nl.uva.se.ast.expression.arithmetical.Substraction;
import nl.uva.se.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ast.expression.literal.StringLiteral;
import nl.uva.se.ast.expression.logical.And;
import nl.uva.se.ast.expression.logical.Equal;
import nl.uva.se.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ast.expression.logical.GreaterThen;
import nl.uva.se.ast.expression.logical.LessOrEqual;
import nl.uva.se.ast.expression.logical.LessThen;
import nl.uva.se.ast.expression.logical.Not;
import nl.uva.se.ast.expression.logical.NotEqual;
import nl.uva.se.ast.expression.logical.Or;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.visitor.Visitor;

public class Interpreter implements Visitor {

	private SymbolTable symbols;

	public Interpreter() {
		symbols = SymbolTable.getInstance();
	}
	
	@Override
	public void visit(Question question) {
		symbols.addSymbol(question.getId(), question.getType());
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		symbols.addSymbol(calculatedQuestion.getId(),
				calculatedQuestion.getType());
	}

	@Override
	public void visit(Form form) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Condition condition) {
		// TODO Auto-generated method stub

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
	public void visit(Negative negative) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Positive positive) {
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
