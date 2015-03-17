package qls.ast.statement.styling;

import java.util.List;

import ql.ast.QLType;
import qls.ast.expression.Literal;
import qls.ast.QLSStatement;

public abstract class StyleRule extends QLSStatement {
	protected final List<Class<? extends QLType>> compatibleTypes;
	private final Literal<?> value;
	
	public StyleRule(List<Class<? extends QLType>> compatibleTypes, Literal<?> value) {
		this.compatibleTypes = compatibleTypes;
		this.value = value;
	}
	
	public Literal<?> getValue() {
		return this.value;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "(" + value.toString() + ")";
	}
	
	public boolean compatibleWith(QLType type) {
		return this.compatibleTypes.contains(type.getClass());
	}
}
