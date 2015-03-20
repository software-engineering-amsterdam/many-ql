package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.ColorValue;

public class Color extends Style{

	private String colorCode;
	
	public Color(String _colorCode, CodeLines _codeLines){
		super(_codeLines);
		this.colorCode = _colorCode;
	}
	
	public java.awt.Color evaluatedValue(){
		return this.evaluate().getValue();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitColor(this);
	}
	
	@Override
	public ColorValue evaluate() {
		return new ColorValue(this.colorCode);
	}
	
	@Override
	public String getStyleType() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "Color(" + this.evaluatedValue().toString() + ")";
	}
}
