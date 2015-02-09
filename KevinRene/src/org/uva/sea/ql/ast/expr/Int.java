package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;

public class Int implements ASTNode {
	
	private int value;
		
	public Int(int value) {
		this.value = value;
	}
	
	
}
