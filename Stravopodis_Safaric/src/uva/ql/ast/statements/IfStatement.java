package uva.ql.ast.statements;

import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.visitor.VisitorInterface;

public class IfStatement extends Statement {
	
	private Expression expression;
	private List<Statement> statement;
	
	public IfStatement(Expression _expression, List<Statement> _statement, CodeLines _codeLines){
		super(_codeLines);
		this.expression = _expression;
		this.statement = _statement;
	}
	public Expression getExpression(){
		return this.expression;
	}
	public List<Statement> getStatement(){
		return this.statement;
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitIfStatement(this);
	}
	@Override
	public String toString(){
		return "IfStatement(" + this.expression.toString() + "," + this.statement.toString() + ")";
	}
}
