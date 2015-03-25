package qls.ast.statement.widget;

import java.util.List;

import ql.ast.QLType;
import qls.ast.Statement;

public abstract class WidgetType extends Statement {
	private final List<QLType> compatibleTypes;
	
	public WidgetType(List<QLType> compatibleTypes) {
		this.compatibleTypes = compatibleTypes;
	}
	
	public boolean isCompatibleWith(QLType type) {
		return compatibleTypes.contains(type);
	}
	
	public boolean isDefault() {
		return false;
	}
}
