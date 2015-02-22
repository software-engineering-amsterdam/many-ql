package uva.ql.ast.statements;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;

public class IfStatement extends Statement {
	
	private Expression expression;
	private Statement statement;
	
	public IfStatement(Expression _expression, Statement _statement, CodeLines _codeLines){
		super(_codeLines);
		this.expression = _expression;
		this.statement = _statement;
	}
	public Expression getExpression(){
		return this.expression;
	}
	public Statement getStatement(){
		return this.statement;
	}
	@Override
	public String toString(){
		return "IfStatement(" + this.expression.toString() + "," + this.statement.toString() + ")";
	}
}
