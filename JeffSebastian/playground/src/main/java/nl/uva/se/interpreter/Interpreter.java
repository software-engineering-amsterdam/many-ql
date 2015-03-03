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
import nl.uva.se.ast.expression.variable.Reference;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.ast.type.Type;
import nl.uva.se.visitor.ExpressionVisitor;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class Interpreter implements FormVisitor, StatementVisitor, ExpressionVisitor<Type> {

	private SymbolTable symbols;
	
	@Override
	public void visit(Question question) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(Form form) {
		symbols = TypeChecker.run(form);
		System.out.println(symbols);
	}

	@Override
	public void visit(Condition condition) {
		// TODO Auto-generated method stub
	}

	@Override
	public Type visit(Not not) {
		return null;

	}

	@Override
	public Type visit(NotEqual notEqual) {
		return null;

	}

	@Override
	public Type visit(Or or) {
		return null;

	}

	@Override
	public Type visit(Addition plus) {
		return null;

	}

	@Override
	public Type visit(Power power) {
		return null;

	}

	@Override
	public Type visit(Multiply multiply) {
		return null;

	}

	@Override
	public Type visit(Modulo modulo) {
		return null;

	}

	@Override
	public Type visit(Negative negative) {
		return null;

	}

	@Override
	public Type visit(Positive positive) {
		return null;

	}

	@Override
	public Type visit(Substraction minus) {
		return null;

	}

	@Override
	public Type visit(LessThen lessThen) {
		return null;

	}

	@Override
	public Type visit(LessOrEqual lessOrEqual) {
		return null;

	}

	@Override
	public Type visit(GreaterThen greaterThen) {
		return null;

	}

	@Override
	public Type visit(GreaterOrEqual greaterOrEqual) {
		return null;

	}

	@Override
	public Type visit(Equal equal) {
		return null;

	}

	@Override
	public Type visit(Divide divide) {
		return null;

	}

	@Override
	public Type visit(And and) {
		return null;

	}

	@Override
	public Type visit(BooleanLiteral booleanLiteral) {
		return null;

	}

	@Override
	public Type visit(DecimalLiteral decimalLiteral) {
		return null;

	}

	@Override
	public Type visit(IntegerLiteral integerLiteral) {
		return null;

	}

	@Override
	public Type visit(StringLiteral stringLiteral) {
		return null;

	}

	@Override
	public Type visit(Reference reference) {
		return null;
		
	}

}
