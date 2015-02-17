package uva.ql.ast.statements;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.supporting.Tuple;

public class Assign extends Statement {
	protected Identifier identifier;
	protected Expression expression;
	
	public Assign(Identifier _identifier, Expression _expression, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.expression = _expression;
	}
	@Override
	public String toString(){
		return "Assign(" + this.identifier.getValue() + "," + this.expression + ")";
	}
}
