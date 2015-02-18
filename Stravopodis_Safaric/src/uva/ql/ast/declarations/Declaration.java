package uva.ql.ast.declarations;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.Value;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public class Declaration extends Statement{

	protected Identifier identifier;
	protected Type<Value> type;
	protected Expression expressions;
	
	public Declaration(Identifier _identifier, Type<Value> _type, Expression _expressions, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
		this.expressions = _expressions;
	}
}
