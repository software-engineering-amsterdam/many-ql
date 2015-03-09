package qls.ast.statement;

import ql.ast.expression.literal.StringLiteral;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSStatementVisitor;

public class Section extends QLSStatement {
	public Section(StringLiteral header, QLSBlock block) {
		
	}
	
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