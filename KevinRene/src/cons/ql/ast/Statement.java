package cons.ql.ast;

import java.util.ArrayList;

import cons.ql.ast.visitor.Visitor;

public abstract class Statement implements ASTNode {
	protected ArrayList<ASTNode> members = new ArrayList<ASTNode>();
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	@Override
	public abstract String toString();
	
	@Override
	public void accept(Visitor visitor) {
		for(ASTNode member: members) {
			member.accept(visitor);
		}
		
		visitor.visit(this);
	}
}