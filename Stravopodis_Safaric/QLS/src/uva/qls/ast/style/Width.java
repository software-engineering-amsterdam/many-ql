package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.IntLiteral;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.NumberValue;

public class Width extends Style{

	private IntLiteral width;
	
	public Width(IntLiteral intLiteral, CodeLines _codeLines) {
		super(_codeLines);
		this.width = intLiteral; 
	}

	public Integer evaluatedValue(){
		return this.width.evaluate().getValue();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitWidth(this);
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.width.evaluate().getValue());
	}
	
	@Override
	public String getStyleType() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "Width(" + this.evaluatedValue().toString() + ")";
	}
}
