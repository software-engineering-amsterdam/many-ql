package uva.sc.qls.logic.style;

import uva.sc.qls.ast.INode;
import uva.sc.qls.ast.INodeVisitor;
import uva.sc.qls.atom.ID;

public interface StyleProperty extends INode{

	public <T> T getValue();
	
}
