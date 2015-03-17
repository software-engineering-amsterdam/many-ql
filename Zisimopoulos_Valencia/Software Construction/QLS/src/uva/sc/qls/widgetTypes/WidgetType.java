package uva.sc.qls.widgetTypes;

import uva.sc.core.types.Type;
import uva.sc.qls.ast.*;

public interface WidgetType extends IQLSNode {

	boolean equals(WidgetType type);

	Type getType();

}