package qlProject.ast.statement.assignment;

import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.type.Type;

public class DirectAssignment extends Assignment {

	public DirectAssignment (String id, String text, Type type){
		super(id, text, type);
	}
	

	@Override
	public void accept(IStatementsVisitor visitor) {
		visitor.visit(this);
	}

}