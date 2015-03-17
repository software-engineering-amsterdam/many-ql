package ast.question;

import java.util.List;

import ast.expression.Expression;
import ast.type.ChoiceType;

public class IfStatement extends Question {

	private final Expression ifExpression;
	private List<Question> ifStatement;
	
	public IfStatement(Expression ifExpression, List<Question> ifStatement) {
		this.ifStatement = ifStatement;
		this.ifExpression = ifExpression;
	}
	
	public Expression getExpression(){
		return ifExpression;
	}
	
	public List<Question> getIfStatement(){
		return ifStatement;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public ChoiceType getType() {
		return new ChoiceType();
	}
	
	@Override
	public String toString() {
		String output = "if " + " ( " + this.ifExpression.toString() + " ) { \n";
		for(Question q: ifStatement)
			output += q.toString() + "\n";
		output += " } ";
	
		return output;
	}
}
