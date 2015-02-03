package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;

public class Ident extends ASTNode {
	private String value;
	
	public Ident(String value) {
		this.value = value;
	}
	
	
}
