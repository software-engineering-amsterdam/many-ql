package cons.ql.ast;


public interface ASTNode {
	@Override
	public String toString();
	
	public void accept(Visitor visitor);
}
