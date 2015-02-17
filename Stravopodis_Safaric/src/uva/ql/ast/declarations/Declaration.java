package uva.ql.ast.declarations;

import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public class Declaration extends Statement implements ASTNode{

	protected Identifier identifier;
	protected Type type;
	protected Expression expressions;
	
	public Declaration(Identifier _identifier, Type _type, Expression _expressions){
		this.identifier = _identifier;
		this.type = _type;
		this.expressions = _expressions;
	}
}
