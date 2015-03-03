package uva.qls.ast.literal;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;
import uva.qls.supporting.Tuple;

public class StringLiteral extends Literal {

	private String value;
	
	public StringLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	public StringLiteral(String _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
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
	public String toString(){
		if (this.value != null) return "StringLiteral(" + this.value + ")";
		else return "StringLiteral()";
	}
	
	@Override
	public StringValue evaluate() {
		
		return new StringValue(this.value);
	}
}
