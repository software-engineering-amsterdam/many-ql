package cons.ql.ast;

import cons.ql.ast.visitor.Visitor;


public interface ASTNode {
	@Override
	public String toString();
	
	public <T> T accept(Visitor<T> visitor);
}
