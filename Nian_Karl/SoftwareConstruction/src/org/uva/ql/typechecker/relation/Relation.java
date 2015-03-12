package org.uva.ql.typechecker.relation;

import org.uva.ql.ast.expression.literal.Identifier;

public class Relation {
	private final Identifier first;
	private final Identifier second;
	
	public Relation(Identifier first, Identifier second) {
		this.first = first;
		this.second = second;
	}
	
	public Identifier getFirst() {
		return first;
	}
	
	public Identifier getSecond() {
		return second;
	}
	
	public boolean isCyclic() {
		return first.toString().equals(second.toString());
	}
	
	public void print() {
		System.out.println("Tuple <" + first.toString() + ", " + second.toString() + ">");
	}
}
