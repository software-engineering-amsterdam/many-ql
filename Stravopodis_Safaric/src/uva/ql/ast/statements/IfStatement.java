package uva.ql.ast.statements;

import java.util.List;

import uva.ql.ast.expressions.Expression;

public class IfStatement extends Statement {
	/*
	   ifStatement		: ifThen = 'if' '(' expr ')' '{' stat* '}' 
						| ifElse = 'if' '(' expr ')' '{' stat* '}' elseStat = 'else' '(' stat* ')';
	 */
	
	protected Expression expression;
	protected List<Statement> children;
	
	public IfStatement(Expression _expression){
		this.expression = _expression;
	}
	public void addChild(Statement child){
		this.children.add(child);
	}
}
