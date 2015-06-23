package uva.ql.ast.visitor;

import uva.ql.ast.expressions.*;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.literals.MoneyLiteral;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.expressions.logic.And;
import uva.ql.ast.expressions.logic.Equal;
import uva.ql.ast.expressions.logic.Greater;
import uva.ql.ast.expressions.logic.Greater_Eq;
import uva.ql.ast.expressions.logic.Less;
import uva.ql.ast.expressions.logic.Less_Eq;
import uva.ql.ast.expressions.logic.NotEqual;
import uva.ql.ast.expressions.logic.Or;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Exponentiation;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;

public interface ExpressionVisitor<T>{
	
	public T visitBinaryExpression(BinaryExpression expression);
	public T visitExpression(Expression expression);
	public T visitExponentiation(Exponentiation exponentiation);
	public T visitAddition(Addition addition);
	public T visitSubstraction(Substraction substraction);
	public T visitMultiplication(Multiplication multipllication);
	public T visitDivision(Division division);
	public T visitAnd(And and);
	public T visitOr(Or or);
	public T visitEqual(Equal equal);
	public T visitNotEqual(NotEqual notEqual);
	public T visitGreaterEqual(Greater_Eq greaterEqual);
	public T visitGreater(Greater greater);
	public T visitLessEqual(Less_Eq lessEqual);
	public T visitLess(Less less);
	
	public T visitIdentifier(Identifier identifier);
	public T visitBooleanLiteral(BooleanLiteral booleanLiteral);
	public T visitMoneyLiteral(MoneyLiteral moneyLiteral);
	public T visitIntLiteral(IntLiteral intLiteral);
	public T visitStringLiteral(StringLiteral stringLiteral);
	
}
