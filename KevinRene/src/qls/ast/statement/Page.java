package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSStatementVisitor;

public class Page extends QLSStatement {
	public Page(Identifier identifier, QLSBlock block) {
		
	}
	
	@Override
	public <T> T accept(QLSStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return null;
	}
}