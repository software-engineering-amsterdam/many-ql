package uva.qls.ast.literal;
import uva.qls.ast.value.*;
import uva.qls.ast.CodeLines;
import uva.qls.supporting.Tuple;

public class IntLiteral extends Literal {
	
	private Integer value;
	
	public IntLiteral(Integer _value, CodeLines _codeLines){
		super(_codeLines);
		this.value=_value;
	}
	
	public IntLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	
	public Integer evaluatedValue(){
		return this.evaluate().getValue().intValue();
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
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}
	
	@Override
	public String toString(){
		if (this.value == null) return "IntegerLiteral()";
		else return "IntegerLiteral(" + String.valueOf(this.value) + ")";
	}
}
