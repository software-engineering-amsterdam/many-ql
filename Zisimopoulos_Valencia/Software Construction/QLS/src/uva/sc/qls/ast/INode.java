package uva.sc.qls.ast;

import uva.sc.qls.ast.INodeVisitor;

public interface INode {
	
	public <T> T accept(INodeVisitor<T> visitor);

}
