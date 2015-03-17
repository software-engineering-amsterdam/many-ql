package org.uva.ql.typechecker.dependency;

import org.uva.ql.ast.expression.literal.Identifier;

public class DependencyPair {
	
	private final Identifier dominant;
	private final Identifier dependent;
	/**
	 * The dependency pair or two identifiers.
	 * Second parameter is dependent on the first one.
	 */
	public DependencyPair(Identifier dominant, Identifier dependent) {
		this.dominant = dominant;
		this.dependent = dependent;
	}
	
	public Identifier getDominant() {
		return dominant;
	}
	
	public Identifier getDependent() {
		return dependent;
	}
	
	public boolean isCyclicDependent() {
		return dominant.equals(dependent);
	}
	
	public void print() {
		System.out.println("Tuple <" + dominant.toString() + ", " + dependent.toString() + ">");
	}
}
