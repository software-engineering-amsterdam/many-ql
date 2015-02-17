package uva.ql.ast.statements;

import java.util.List;

import uva.ql.ast.expressions.Expression;
import uva.ql.supporting.Tuple;

public class IfStatement extends Statement {
	
	protected Expression expression;
	protected List<Statement> statements;
	
	public IfStatement(Expression _expression, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.expression = _expression;
	}
	public Expression getExpression(){
		return this.expression;
	}
	public List<Statement> getStatements(){
		return this.statements;
	}
}
