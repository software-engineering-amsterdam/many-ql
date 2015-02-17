package uva.ql.ast.statements;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.supporting.Tuple;

public class Assign extends Statement {
	private Identifier identifier;
	private Expression expression;
	private String string;
	
	public Assign(Identifier _identifier, Expression _expression, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.expression = _expression;
	}
	public Assign(Identifier _identifier, String _string, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.string = _string;
	}
	@Override
	public String toString(){
		if (this.expression != null)
			return "Assign(" + this.identifier.getValue() + "," + this.expression + ")";
		else
			return "Assign(" + this.identifier.getValue() + "," + this.string + ")";
	}
}
