package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.IntLiteral;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.NumberValue;

public class Height extends Style{

	private IntLiteral height;

	public Height(IntLiteral _value, CodeLines _codeLines) {
		super(_codeLines);
		this.height = _value;
	}

	public Integer evaluatedValue(){
		return this.evaluate().getValue();
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitHeight(this);
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.height.evaluate().getValue());
	}
	
	@Override
	public String getStyleType() {
		return this.getClass().getName();
	}
	
	@Override
	public String toString() {
		return "Height(" + this.evaluatedValue().toString() + ")";
	}
}
