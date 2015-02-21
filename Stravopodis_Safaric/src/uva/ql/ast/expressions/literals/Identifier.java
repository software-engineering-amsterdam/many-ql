package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;

public class Identifier extends Value<String>{
	protected String identifier;
	
	public Identifier(String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
	}
	public String getValue(){
		return this.identifier;
	}
	@Override
	public String toString() {
		return "Identifier(" + this.identifier + ")";
	}
	
}
