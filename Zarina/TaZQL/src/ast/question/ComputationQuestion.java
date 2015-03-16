package ast.question;

import ast.expression.Expression;
import ast.expression.variables.Id;
import ast.type.Type;

public class ComputationQuestion extends SimpleQuestion {
	private final Expression expression;
		
	public ComputationQuestion (Id ID, String TEXT, Type TYPE, Expression expression) {
		super(ID, TEXT, TYPE);
		this.expression = expression;
	}	
	
	public Expression getExpression(){
		return expression;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.getQuestionId().toString() + " \"" + super.getQuestionText() + "\" " 
			 + super.getQuestionType().toString() + " ( " + this.expression.toString() + " )" ;
	}
}
