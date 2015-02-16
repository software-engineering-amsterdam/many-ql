package cons.ql.ast.visitor.typechecker;

import cons.ql.ast.expression.literal.*;
import cons.ql.ast.visitor.QLTypeVisitor;

public class QLTypeChecker implements QLTypeVisitor {
	public QLTypeChecker() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void visit(QLBoolean booleanNode) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void visit(QLFloat floatNode) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void visit(QLIdent identNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(QLInt intNode) {
		System.out.println("Visit QL int.");
	}

	@Override
	public void visit(QLString stringNode) {
		// TODO Auto-generated method stub
		
	}
}
