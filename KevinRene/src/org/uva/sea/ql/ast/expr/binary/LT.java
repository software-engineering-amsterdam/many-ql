package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class LT extends Binary {
	
	final static String operator = "<";

	public LT(Expr left, Expr right) {
		super(left, right, operator);
	}
}
