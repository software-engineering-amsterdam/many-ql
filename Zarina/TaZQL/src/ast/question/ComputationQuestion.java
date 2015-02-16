package ast.question;

import ast.expression.Expression;
import ast.expression.variables.Id;
import ast.type.TextType;
import ast.type.Type;

public abstract class ComputationQuestion extends SimpleQuestion {
	private Expression expression;
		
	public ComputationQuestion (Id questionID, TextType questionText, Type questionType, Expression expression) {
		super(questionID, questionText, questionType);
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
