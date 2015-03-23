package uva.ql.ast.statements;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.visitor.StatementVisitor;

public class Assign extends Statement {
	
	private Identifier identifier;
	private Expression expression;
	
	public Assign(Identifier _identifier, Expression _expression, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.expression = _expression;
	}
	
	public Expression getExpression(){
		return this.expression;
	}
	
	public Identifier getIdentifier(){
		return this.identifier;
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitAssign(this);
	}
	@Override
	public String toString(){
		return "Assign(" + this.identifier.getEvaluatedValue() + "," + this.expression + ")";
	}
}
