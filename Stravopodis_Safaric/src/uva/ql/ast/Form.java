package uva.ql.ast;

import uva.ql.ast.expressions.literals.Identifier;

public class Form{
	
	protected Identifier identifier;
	
	public Form (Identifier _identifier){
		this.identifier = _identifier;
	}
}
