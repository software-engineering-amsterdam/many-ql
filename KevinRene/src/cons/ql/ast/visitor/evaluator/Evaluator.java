package cons.ql.ast.visitor.evaluator;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Neg;
import cons.ql.ast.expression.arithmetic.Pos;
import cons.ql.ast.expression.arithmetic.Sub;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.FloatLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.relational.And;
import cons.ql.ast.expression.relational.Eq;
import cons.ql.ast.expression.relational.GEq;
import cons.ql.ast.expression.relational.GT;
import cons.ql.ast.expression.relational.LEq;
import cons.ql.ast.expression.relational.LT;
import cons.ql.ast.expression.relational.NEq;
import cons.ql.ast.expression.relational.Not;
import cons.ql.ast.expression.relational.Or;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;
import cons.value.BooleanValue;
import cons.value.FloatValue;
import cons.value.IntegerValue;
import cons.value.StringValue;

@SuppressWarnings("rawtypes")
public class Evaluator implements ExpressionVisitor<Value>, StatementVisitor<Value> {
	private ValueEnvironment valueEnv;
	
	public Evaluator(ValueEnvironment valueEnv) {
		this.valueEnv = valueEnv;
	}
	
	
	@Override
	public Value visit(Pos pos) {
		Value expressionValue = pos.getExpression().accept(this);
		
		return expressionValue.positive();
	}

	@Override
	public Value visit(Not not) {
		Value expressionValue = not.getExpression().accept(this);
		
		return expressionValue.not();
	}

	@Override
	public Value visit(Neg neg) {
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
	public Value visit(NEq nEq) {
		Value leftValue = nEq.getLeft().accept(this);
		Value rightValue = nEq.getRight().accept(this);
		
		return leftValue.notEqualTo(rightValue);
	}

	@Override
	public Value visit(LT lt) {
		Value leftValue = lt.getLeft().accept(this);
		Value rightValue = lt.getRight().accept(this);
		
		return leftValue.lowerThan(rightValue);
	}

	@Override
	public Value visit(LEq lEq) {
		Value leftValue = lEq.getLeft().accept(this);
		Value rightValue = lEq.getRight().accept(this);
		
		return leftValue.lowerOrEqual(rightValue);
	}

	@Override
	public Value visit(GT gt) {
		Value leftValue = gt.getLeft().accept(this);
		Value rightValue = gt.getRight().accept(this);
		
		return leftValue.greaterThan(rightValue);
	}

	@Override
	public Value visit(GEq gEq) {
		Value leftValue = gEq.getLeft().accept(this);
		Value rightValue = gEq.getRight().accept(this);
		
		return leftValue.greaterOrEqual(rightValue);
	}

	@Override
	public Value visit(Eq eq) {
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
		return new StringValue(stringLiteral.getValue());
	}

	@Override
	public Value visit(IntegerLiteral integerLiteral) {
		return new IntegerValue(integerLiteral.getValue());
	}

	@Override
	public Value visit(FloatLiteral floatLiteral) {
		return new FloatValue(floatLiteral.getValue());
	}

	@Override
	public Value visit(BooleanLiteral booleanLiteral) {
		return new BooleanValue(booleanLiteral.getValue());
	}

	@Override
	public Value visit(Add add) {
		Value leftValue = add.getLeft().accept(this);
		Value rightValue = add.getRight().accept(this);
		
		return leftValue.add(rightValue);
	}

	@Override
	public Value visit(Div div) {
		Value leftValue = div.getLeft().accept(this);
		Value rightValue = div.getRight().accept(this);
		
		return leftValue.divide(rightValue);
	}

	@Override
	public Value visit(Mul mul) {
		Value leftValue = mul.getLeft().accept(this);
		Value rightValue = mul.getRight().accept(this);
		
		return leftValue.multiply(rightValue);
	}

	@Override
	public Value visit(Sub sub) {
		Value leftValue = sub.getLeft().accept(this);
		Value rightValue = sub.getRight().accept(this);
		
		return leftValue.subtract(rightValue);
	}
	
	@Override
	public Value visit (Identifier identifier) {
		return valueEnv.resolve(identifier);
	}
}
