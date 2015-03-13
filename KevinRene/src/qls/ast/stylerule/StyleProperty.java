package qls.ast.stylerule;

import java.util.List;

import ql.ast.expression.QLType;
import qls.ast.QLSStatement;

public abstract class StyleProperty extends QLSStatement {
	protected List<Class<? extends QLType>> compatibleTypes;
	
	public StyleProperty(List<Class<? extends QLType>> compatibleTypes) {
		this.compatibleTypes = compatibleTypes;
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public boolean compatibleWith(QLType type) {
		return this.compatibleTypes.contains(type.getClass());
	}
}
