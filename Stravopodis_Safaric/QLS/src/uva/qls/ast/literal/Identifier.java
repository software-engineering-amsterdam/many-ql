package uva.qls.ast.literal;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;

public class Identifier extends Literal {
	private String identifier;
	
	public Identifier (String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
	}
	@Override
	public StringValue evaluate(){
		return new StringValue(this.identifier);
	}
	@Override
	public String toString() {
		
		return "Identifier(" + this.identifier + ")";
	}
}
