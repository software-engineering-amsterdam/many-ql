package uva.ql.ast.declarations;

import uva.ql.ast.ASTNode;
import uva.ql.ast.expressions.Expressions;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.supporting.Tuple;

public class Declarations implements ASTNode{

	protected Identifier identifier;
	protected Type type;
	protected Expressions expressions;
	
	public Declarations(Identifier _identifier, Type _type, Expressions _expressions){
		this.identifier = _identifier;
		this.type = _type;
		this.expressions = _expressions;
	}
	
	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
