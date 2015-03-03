package org.tax.parser;

import org.tax.datatypes.QLBoolean;
import org.tax.datatypes.QLInteger;
import org.tax.datatypes.QLType;
import org.tax.expression.Expression;

public class VariableWithExpr<T extends QLType> extends Variable {

	private Expression<? extends QLType> expr = null;

	public VariableWithExpr(String name, String value, String type, Expression<T> expr) {
		super(name, value, type);
		this.expr = expr;
		System.out.println(expr.evaluate());
	}

}
