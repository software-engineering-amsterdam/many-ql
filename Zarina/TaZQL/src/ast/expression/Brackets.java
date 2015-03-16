package ast.expression;

import ast.type.Type;

public class Brackets extends Expression {
	private final Expression bracketsExpression;

	public Brackets (Expression bracketsExpression) {
		this.bracketsExpression = bracketsExpression;
	}
	
	public Expression getBracketsExpression() {
		return bracketsExpression;
	}
			
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString(){
		return "(" + this.bracketsExpression.toString() + ")";
	}

	@Override
	public Type getType() {
		return this.bracketsExpression.getType();
	}
}
