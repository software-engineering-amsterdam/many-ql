package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.NumberValue;

public class FontSize extends Font{

	private Integer value;
	
	public FontSize(Integer _value, CodeLines _codeLines) {
		super(_codeLines);
		this.value = _value;
	}

	public Integer evaluatedValue(){
		return this.evaluate().getValue().intValue();
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}

	@Override
	public String toString() {
		return "FontSize(" + this.evaluatedValue().toString() + ")";
	}

}
