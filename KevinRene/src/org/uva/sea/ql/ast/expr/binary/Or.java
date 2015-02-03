package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class Or extends Binary {

	final static String operator = "||";

	public Or(Expr left, Expr right) {
		super(left, right, operator);
	}
}
