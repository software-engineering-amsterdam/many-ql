package ast.question;

import java.util.ArrayList;

import ast.expression.Expression;

public class IfStatement extends Questions {

	private Expression ifExpression;
	private ArrayList<Questions> ifStatement, elseStatement;
	
	public IfStatement(Expression ifExpression, ArrayList<Questions> ifStatement,  ArrayList<Questions> elseStatement) {
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
		this.ifExpression = ifExpression;
	}
	
	public Expression getExpression(){
		return ifExpression;
	}
	
	public ArrayList<Questions> getIfStatement(){
		return ifStatement;
	}
	
	public ArrayList<Questions> getElseStatement(){
		return elseStatement;
	}
	
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}

// 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'