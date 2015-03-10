package qls.ast.statement;

import ql.ast.QLNode;
import ql.ast.expression.QLType;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSVisitor;

public class Default extends QLSStatement {	
	public Default(QLType type, QLNode undeterminedNode) {
		
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
