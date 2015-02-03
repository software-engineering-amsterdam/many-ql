package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class Mul extends Binary {

	final static String operator = "*";
	
	public Mul(Expr left, Expr right) {
		super(left, right, operator);
	}
}
