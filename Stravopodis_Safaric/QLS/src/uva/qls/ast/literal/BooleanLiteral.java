package uva.qls.ast.literal;

import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.BooleanValue;
import uva.qls.ast.CodeLines;

public class BooleanLiteral extends Literal {
	
	private boolean value;
	
	public BooleanLiteral(boolean _value, CodeLines _codeLines){
		super(_codeLines);
		this.value=_value;
	}
	
	public BooleanLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitBooleanLiteral(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue(this.value);
	}
	@Override
	public String toString() {
		return "BooleanLiteral(" + String.valueOf(this.value) + ")";
	}
}
