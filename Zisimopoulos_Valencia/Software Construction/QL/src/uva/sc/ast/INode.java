package uva.sc.ast;

public interface INode {
	
	public <T> T accept(INodeVisitor<T> visitor);

}
