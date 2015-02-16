package ast.question;

import java.util.ArrayList;

import ast.expression.Expression;

public abstract class IfStatement extends IQuestionVisitable {

	private Expression ifExpression;
	private ArrayList<IQuestionVisitable> ifStatement, elseStatement;
	
	public IfStatement(Expression ifExpression, ArrayList<IQuestionVisitable> ifStatement,  ArrayList<IQuestionVisitable> elseStatement) {
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
		this.ifExpression = ifExpression;
	}
	
	public Expression getExpression(){
		return ifExpression;
	}
	
	public ArrayList<IQuestionVisitable> getIfStatement(){
		return ifStatement;
	}
	
	public ArrayList<IQuestionVisitable> getElseStatement(){
		return elseStatement;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

// 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'