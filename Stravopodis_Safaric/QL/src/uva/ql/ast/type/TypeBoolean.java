package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.TypeVisitor;

public class TypeBoolean extends Type{

	public TypeBoolean(){
		super();
	}
	
	public TypeBoolean(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public BooleanValue typeInitialValue() {
		return new BooleanValue(false);
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visitTypeBoolean(this);
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}
}
