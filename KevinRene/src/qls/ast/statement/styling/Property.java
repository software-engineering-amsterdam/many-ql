package qls.ast.statement.styling;

import java.util.List;

import ql.ast.QLType;
import qls.ast.expression.Literal;
import qls.ast.QLSStatement;

public abstract class Property extends QLSStatement {
	private final List<QLType> compatibleTypes;
	private final Literal<?> value;
	
	public Property(List<QLType> compatibleTypes, Literal<?> value) {
		this.compatibleTypes = compatibleTypes;
		this.value = value;
	}
	
	public Literal<?> getValue() {
		return this.value;
	}
	
	public boolean isCompatibleWith(QLType type) {
		return compatibleTypes.contains(type);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + value.toString() + ")";
	}
}
