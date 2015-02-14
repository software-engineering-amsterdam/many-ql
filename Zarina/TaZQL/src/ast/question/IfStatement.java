package ast.question;

import ast.expression.Expression;

public class IfStatement extends Questions {

	private Expression expression;
	
	public IfStatement(Expression expression) {
		this.expression = expression;
	}
	
	public Expression getExpression(){
		return expression;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}


//'if' '(' expression ')' '{' question+ '}'	