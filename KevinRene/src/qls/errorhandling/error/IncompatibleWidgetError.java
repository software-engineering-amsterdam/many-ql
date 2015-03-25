package qls.errorhandling.error;

import ql.ast.QLNode;
import ql.ast.QLType;
import qls.ast.statement.widget.Widget;

public class IncompatibleWidgetError extends qls.errorhandling.Error {
	public IncompatibleWidgetError(QLNode origin, QLType type, Widget widget) {
		super(origin, "(" + origin.getClass().getSimpleName() + ") with type "
				+ "(" + type + ") is not compatible with widget of type "
				+ "(" + widget.getWidgetType() + ").");
	}
}
