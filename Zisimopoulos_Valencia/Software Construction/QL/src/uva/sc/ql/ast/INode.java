package uva.sc.ql.ast;

public interface INode {

	public <T> T accept(INodeVisitor<T> visitor);
	
}
