package nl.uva.se.ql.ast.expression;

import nl.uva.se.ql.ast.expression.arithmetical.Addition;
import nl.uva.se.ql.ast.expression.arithmetical.Divide;
import nl.uva.se.ql.ast.expression.arithmetical.Modulo;
import nl.uva.se.ql.ast.expression.arithmetical.Multiply;
import nl.uva.se.ql.ast.expression.arithmetical.Negative;
import nl.uva.se.ql.ast.expression.arithmetical.Positive;
import nl.uva.se.ql.ast.expression.arithmetical.Power;
import nl.uva.se.ql.ast.expression.arithmetical.Substraction;
import nl.uva.se.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ql.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ql.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ql.ast.expression.literal.StringLiteral;
import nl.uva.se.ql.ast.expression.logical.And;
import nl.uva.se.ql.ast.expression.logical.Equal;
import nl.uva.se.ql.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ql.ast.expression.logical.GreaterThen;
import nl.uva.se.ql.ast.expression.logical.LessOrEqual;
import nl.uva.se.ql.ast.expression.logical.LessThen;
import nl.uva.se.ql.ast.expression.logical.Not;
import nl.uva.se.ql.ast.expression.logical.NotEqual;
import nl.uva.se.ql.ast.expression.logical.Or;
import nl.uva.se.ql.ast.expression.variable.Reference;

public interface ExpressionVisitor<T> {
	
	// Arithmetical Expressions
	public T visit(Addition plus);
	public T visit(Divide divide);
	public T visit(Power power);
	public T visit(Multiply multiply);
	public T visit(Modulo modulo);
	public T visit(Negative negative);
	public T visit(Positive positive);
	public T visit(Substraction minus);
		
	// Logical Expressions
	public T visit(Not not);
	public T visit(NotEqual notEqual);
	public T visit(Or or);
	public T visit(LessThen lessThen);
	public T visit(LessOrEqual lessOrEqual);
	public T visit(GreaterThen greaterThen);
	public T visit(GreaterOrEqual greaterOrEqual);
	public T visit(Equal equal);
	public T visit(And and);
	
	// Literals
	public T visit(BooleanLiteral booleanLiteral);
	public T visit(DecimalLiteral decimalLiteral);
	public T visit(IntegerLiteral integerLiteral);
	public T visit(StringLiteral stringLiteral);
	public T visit(Reference reference);

}
