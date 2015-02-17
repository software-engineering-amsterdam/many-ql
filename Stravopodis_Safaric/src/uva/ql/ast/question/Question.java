package uva.ql.ast.question;

import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.Value;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public class Question extends Statement {
	
	protected Identifier identifier;
	protected Type<Value> type;
	
	public Question(Identifier _identifier, Type<Value> _type, Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
		this.type = _type;
	}
	
	@Override
	public String toString(){
		return null;
	}
}



