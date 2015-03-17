package uva.sc.qls.ast;

import uva.sc.core.INode;
import uva.sc.qls.ast.IQLSNodeVisitor;

public interface IQLSNode extends INode {

	public <T> T accept(IQLSNodeVisitor<T> visitor);

}
