package org.uva.sea.ql.ast;

public class Expr<T> extends ASTNode {
	
	public T value;
	
	public Expr(T value) {
		this.value = value;
	}
	
	public Expr() {
		
	}
	
	public T get() {
		return this.value;
	}
}
