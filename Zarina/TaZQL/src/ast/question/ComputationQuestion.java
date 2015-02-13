package ast.question;

import ast.expression.Expression;
import ast.type.Id;
import ast.type.Text;
import ast.type.Type;

public class ComputationQuestion extends SimpleQuestion {
	private Expression expression;
		
	public ComputationQuestion (Id questionID, Text questionText, Type questionType, Expression expression) {
		super(questionID, questionText, questionType);
		this.expression = expression;
	}	
	
	public Expression getExpress(){
		return expression;
	}
	
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
