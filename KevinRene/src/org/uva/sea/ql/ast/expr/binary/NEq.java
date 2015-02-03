package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class NEq extends Binary {
	final static String operator = "!=";

	public NEq(Expr left, Expr right) {
		super(left, right, operator);
	}
}
