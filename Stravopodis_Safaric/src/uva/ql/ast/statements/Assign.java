package uva.ql.ast.statements;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.visitor.VisitorInterface;

public class Assign extends Statement {
	private Identifier identifier;
	private Expression expression;
	private String string;
	
	public Assign(Identifier _identifier, Expression _expression, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.expression = _expression;
	}
	public Assign(Identifier _identifier, String _string, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.string = _string;
	}
	public Expression getExpression(){
		return this.expression;
	}
	public Identifier getIdentifier(){
		return this.identifier;
	}
	public CodeLines getCodeLines(){
		return this.codeLines;
	}
	public String getString(){
		return this.string;
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitAssign(this);
	}
	@Override
	public String toString(){
		if (this.expression != null)
			return "Assign(" + this.identifier.evaluate().getValue() + "," + this.expression + ")";
		else
			return "Assign(" + this.identifier.evaluate().getValue() + "," + this.string + ")";
	}
}
