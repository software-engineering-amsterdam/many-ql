package com.form.language.ast.expression.math;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.IntValue;

public class Negation extends UnaryExpression implements Expression {
	
	public Negation(Expression value) {
		super(value);
	}

	@Override
	public IntValue evaluate() {		
		return ((IntLiteral)value).evaluate().Negation();
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
