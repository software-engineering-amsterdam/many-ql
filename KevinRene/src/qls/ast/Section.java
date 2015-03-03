package qls.ast;

import qls.ast.visitor.Visitor;

public class Section implements ASTNode {

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}