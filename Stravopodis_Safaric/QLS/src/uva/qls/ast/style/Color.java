package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.ColorValue;

public class Color extends Style{

	private Integer colorCode;
	
	public Color(Integer _colorCode, CodeLines _codeLines){
		super(_codeLines);
		this.colorCode = _colorCode;
	}
	

	public java.awt.Color evaluatedValue(){
		return this.evaluate().getValue();
	}
	
	@Override
	public ColorValue evaluate() {
		return new ColorValue(this.colorCode);
	}

	@Override
	public String toString() {
		return "Color(" + this.evaluatedValue().toString() + ")";
	}
	
	
}
