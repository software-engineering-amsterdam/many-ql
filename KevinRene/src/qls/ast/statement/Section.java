package qls.ast.statement;

import qls.ast.Statement;
import qls.ast.visitor.Visitor;

public class Section extends Statement {
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}