package uva.ql.ast.expressions.literals;

import uva.ql.supporting.Tuple;

public class Identifier extends Value<String>{
	protected String identifier;
	
	public Identifier(String _identifier){
		this.identifier = _identifier;
	}
	@Override
	public String getValue(){
		return this.identifier;
	}
	@Override
	public String toString() {
		return null;
	}
	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
