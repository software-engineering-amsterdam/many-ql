package nl.uva.se.visitor;

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

public interface Visitor {
	
	public void visit(Form form);
	public void visit(Question question);
	public void visit(CalculatedQuestion calculatedQuestion);
	public void visit(Condition condition);
	public void visit(Not not);
	public void visit(NotEqual notEqual);
	public void visit(Or or);
	public void visit(Addition plus);
	public void visit(Power power);
	public void visit(Multiply multiply);
	public void visit(Modulo modulo);
	public void visit(Negative negative);
	public void visit(Positive positive);
	public void visit(Substraction minus);
	public void visit(LessThen lessThen);
	public void visit(LessOrEqual lessOrEqual);
	public void visit(GreaterThen greaterThen);
	public void visit(GreaterOrEqual greaterOrEqual);
	public void visit(Equal equal);
	public void visit(Divide divide);
	public void visit(And and);
	public void visit(BooleanLiteral booleanLiteral);
	public void visit(DecimalLiteral decimalLiteral);
	public void visit(IntegerLiteral integerLiteral);
	public void visit(StringLiteral stringLiteral);
	public void visit(Reference reference);
}
