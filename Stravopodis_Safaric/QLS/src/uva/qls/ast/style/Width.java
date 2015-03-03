package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.NumberValue;

public class Width extends Style{

	private Integer width;
	
	public Width(Integer _width, CodeLines _codeLines) {
		super(_codeLines);
		this.width = _width; 
	}

	public Integer evaluatedValue(){
		return this.evaluate().getValue().intValue();
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.width);
	}

	@Override
	public String toString() {
		return "Width(" + this.evaluatedValue().toString() + ")";
	}
	
	
	
}
