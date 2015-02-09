package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Expr;

public class Int extends Expr {
	
	private int value;
		
	public Int(int value) {
		this.value = value;
	}

	@Override
	public String show() {
		return String.valueOf(value);
	}
}
