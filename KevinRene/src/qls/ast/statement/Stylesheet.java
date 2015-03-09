package qls.ast.statement;

import qls.QLSNode;
import qls.ast.visitor.Visitor;

public class Stylesheet implements QLSNode {

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}