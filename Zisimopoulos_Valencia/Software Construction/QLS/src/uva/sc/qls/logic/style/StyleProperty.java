package uva.sc.qls.logic.style;

import uva.sc.qls.ast.IQLSNode;

public interface StyleProperty extends IQLSNode {

	public <T> T getValue();

}
