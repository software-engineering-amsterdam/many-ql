package uva.ql.ast.statements;

import uva.ql.ast.ASTNode;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;

public class Assign extends Statement implements ASTNode{
	protected Identifier identifier;
	protected Expression expression;
	
	public Assign(Identifier _identifier, Expression _expression){
		this.identifier = _identifier;
		this.expression = _expression;
	}
}
