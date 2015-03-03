package uva.qls.ast.literal;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.Tuple;

public class Identifier extends Literal {
	private String identifier;
	
	public Identifier (String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier=_identifier;
	}
	
	@Override
	public Tuple<Integer, Integer> getLOCTuple() {
		return this.codeLines.getCodeLocation();
	}

	@Override
	public CodeLines getLOC() {
		return this.codeLines;
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
