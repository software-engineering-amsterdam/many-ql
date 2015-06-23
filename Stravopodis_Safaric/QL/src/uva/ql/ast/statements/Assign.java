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
	
	public Expression getAssignExpression(){
		return this.expression;
	}
	
	public Identifier getAssignIdentifier(){
		return this.identifier;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitAssign(this);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public String toString(){
		return "Assign(" + this.identifier.getValue() + "," + this.expression + ")";
	}
}
