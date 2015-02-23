package ast.question;

import java.util.List;

import ast.expression.Expression;

public class IfElseStatement extends IfStatement {

	private List<Question> elseStatement;
		
	public IfElseStatement(Expression ifExpression, List<Question> ifStatement, List<Question> elseStatement) {
		super(ifExpression, ifStatement);
		this.elseStatement = elseStatement;
	}
		
	public List<Question> getElseStatement(){
		return elseStatement;
	}
				
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		String output = super.toString();
		output += "\n else { \n";
			for(Question qe: elseStatement)
				output += qe.toString() + "\n";
		output += " }";
	return output;
	}
}
