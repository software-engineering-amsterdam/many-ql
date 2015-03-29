package uva.ql.interpreter.typecheck.depedency;

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
import uva.ql.ast.visitor.ExpressionVisitor;

public class DependencyExpressionVisitor implements ExpressionVisitor<Expression>{

	private IdentifierSet identifierList = new IdentifierSet();
	
	@Override
	public Expression visitBinaryExpression(BinaryExpression expression) {
		
		Expression left = expression.getLeftExpr();
		Expression right = expression.getRightExpr();
	
		if (left.isIdentifier()){
			Identifier identifier = (Identifier)left;
			identifierList.putValue(identifier.getValue());
		}
		
		if (right.isIdentifier()){
			Identifier identifier = (Identifier)right;
			identifierList.putValue(identifier.getValue());
		}
		
		left.accept(this);
		right.accept(this);
		
		return null;
	}
	
	public IdentifierSet getIdentifierSet(){
		return this.identifierList;
	}

	@Override
	public Expression visitExpression(Expression expression) {
		this.identifierList = new IdentifierSet();
		expression.accept(this);
		return null;
	}

	@Override
	public Expression visitExponentiation(Exponentiation exponentiation) {
		return this.visitBinaryExpression(exponentiation);
	}

	@Override
	public Expression visitAddition(Addition addition) {
		return this.visitBinaryExpression(addition);
	}

	@Override
	public Expression visitSubstraction(Substraction substraction) {
		return this.visitBinaryExpression(substraction);
	}

	@Override
	public Expression visitMultiplication(Multiplication multipllication) {
		return this.visitBinaryExpression(multipllication);
	}

	@Override
	public Expression visitDivision(Division division) {
		return this.visitBinaryExpression(division);
	}

	@Override
	public Expression visitAnd(And and) {
		return this.visitBinaryExpression(and);
	}

	@Override
	public Expression visitOr(Or or) {
		return this.visitBinaryExpression(or);
	}

	@Override
	public Expression visitEqual(Equal equal) {
		return this.visitBinaryExpression(equal);
	}

	@Override
	public Expression visitNotEqual(NotEqual notEqual) {
		return this.visitBinaryExpression(notEqual);
	}

	@Override
	public Expression visitGreaterEqual(Greater_Eq greaterEqual) {
		return this.visitBinaryExpression(greaterEqual);
	}

	@Override
	public Expression visitGreater(Greater greater) {
		return this.visitBinaryExpression(greater);
	}

	@Override
	public Expression visitLessEqual(Less_Eq lessEqual) {
		return this.visitBinaryExpression(lessEqual);
	}

	@Override
	public Expression visitLess(Less less) {
		return this.visitBinaryExpression(less);
	}

	@Override
	public Identifier visitIdentifier(Identifier identifier) {
		return identifier;
	}

	@Override
	public Expression visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitMoneyLiteral(MoneyLiteral moneyLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitIntLiteral(IntLiteral intLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitStringLiteral(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

}
