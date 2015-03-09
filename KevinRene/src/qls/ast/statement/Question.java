package qls.ast.statement;

import qls.ast.QLSStatement;
import qls.ast.visitor.QLSStatementVisitor;

public class Question extends QLSStatement {

	@Override
	public <T> T accept(QLSStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
