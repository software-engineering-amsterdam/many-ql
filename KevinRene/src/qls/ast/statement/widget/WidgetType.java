package qls.ast.statement.widget;

import java.util.List;

import ql.ast.QLType;
import qls.ast.QLSStatement;

public abstract class WidgetType extends QLSStatement {
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
