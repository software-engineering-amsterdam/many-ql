package ql.ast.visitor.evaluator;

import ql.Value;
import ql.ast.Expression;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Negation;
import ql.ast.expression.arithmetic.Positive;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.booleanalgebra.And;
import ql.ast.expression.booleanalgebra.Not;
import ql.ast.expression.booleanalgebra.Or;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.MoneyLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.Equal;
import ql.ast.expression.relational.Greater;
import ql.ast.expression.relational.GreaterOrEqual;
import ql.ast.expression.relational.Lower;
import ql.ast.expression.relational.LowerOrEqual;
import ql.ast.expression.relational.NotEqual;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;
import ql.value.UndefinedValue;

public class Evaluator extends StatementVisitor<Value> implements ExpressionVisitor<Value>, TypeVisitor<Void> {
	private ValueEnvironment valueEnv;
	
	private Evaluator(ValueEnvironment valueEnv) {
		this.valueEnv = valueEnv;
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
	}
	
	public static Value check(Statement tree, ValueEnvironment valueEnvironment) {
		Evaluator evaluator = new Evaluator(valueEnvironment);
		
		return tree.accept(evaluator);
	}
	
	public static Value check(Expression tree, ValueEnvironment valueEnvironment) {
		Evaluator evaluator = new Evaluator(valueEnvironment);
		
		return tree.accept(evaluator);
	}
	
	@Override
	public Value visit(Positive pos) {
		Value expressionValue = pos.getExpression().accept(this);
		
		return expressionValue.positive();
	}

	@Override
	public Value visit(Not not) {
		Value expressionValue = not.getExpression().accept(this);
		
		return expressionValue.not();
	}

	@Override
	public Value visit(Negation neg) {
		Value expressionValue = neg.getExpression().accept(this);
		
		return expressionValue.negative();
	}

	@Override
	public Value visit(Or or) {
		Value leftValue = or.getLeft().accept(this);
		Value rightValue = or.getRight().accept(this);
		
		return leftValue.or(rightValue);
	}

	@Override
	public Value visit(NotEqual nEq) {
		Value leftValue = nEq.getLeft().accept(this);
		Value rightValue = nEq.getRight().accept(this);
		
		return leftValue.notEqualTo(rightValue);
	}

	@Override
	public Value visit(Lower lt) {
		Value leftValue = lt.getLeft().accept(this);
		Value rightValue = lt.getRight().accept(this);
		
		return leftValue.lowerThan(rightValue);
	}

	@Override
	public Value visit(LowerOrEqual lEq) {
		Value leftValue = lEq.getLeft().accept(this);
		Value rightValue = lEq.getRight().accept(this);
		
		return leftValue.lowerOrEqual(rightValue);
	}

	@Override
	public Value visit(Greater gt) {
		Value leftValue = gt.getLeft().accept(this);
		Value rightValue = gt.getRight().accept(this);
		
		return leftValue.greaterThan(rightValue);
	}

	@Override
	public Value visit(GreaterOrEqual gEq) {
		Value leftValue = gEq.getLeft().accept(this);
		Value rightValue = gEq.getRight().accept(this);
		
		return leftValue.greaterOrEqual(rightValue);
	}

	@Override
	public Value visit(Equal eq) {
		Value leftValue = eq.getLeft().accept(this);
		Value rightValue = eq.getRight().accept(this);
		
		return leftValue.equalTo(rightValue);
	}

	@Override
	public Value visit(And and) {
		Value leftValue = and.getLeft().accept(this);
		Value rightValue = and.getRight().accept(this);
		
		return leftValue.and(rightValue);
	}

	@Override
	public Value visit(StringLiteral stringLiteral) {
		return stringLiteral.getValue();
	}

	@Override
	public Value visit(IntegerLiteral integerLiteral) {
		return integerLiteral.getValue();
	}

	@Override
	public Value visit(FloatLiteral floatLiteral) {
		return floatLiteral.getValue();
	}

	@Override
	public Value visit(BooleanLiteral booleanLiteral) {
		return booleanLiteral.getValue();
	}
	
	@Override
	public Value visit(MoneyLiteral moneyLiteral) {
		return moneyLiteral.getValue();
	}

	@Override
	public Value visit(Add add) {
		Value leftValue = add.getLeft().accept(this);
		Value rightValue = add.getRight().accept(this);
		
		return leftValue.add(rightValue);
	}

	@Override
	public Value visit(Divide div) {
		Value leftValue = div.getLeft().accept(this);
		Value rightValue = div.getRight().accept(this);
		
		return leftValue.divide(rightValue);
	}

	@Override
	public Value visit(Multiply mul) {
		Value leftValue = mul.getLeft().accept(this);
		Value rightValue = mul.getRight().accept(this);
		
		return leftValue.multiply(rightValue);
	}

	@Override
	public Value visit(Subtract sub) {
		Value leftValue = sub.getLeft().accept(this);
		Value rightValue = sub.getRight().accept(this);
		
		return leftValue.subtract(rightValue);
	}
	
	@Override
	public Value visit (Identifier identifier) {
		Value val = valueEnv.resolve(identifier);
		
		if (val == null) {
			return new UndefinedValue();
		}
		
		return val;
	}
}
