package com.form.language.ast.expression.math;

import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.values.IntValue;

public class Negation extends UnaryExpression implements PrimitiveExpression {
	
	public Negation(PrimitiveExpression value) {
		super(value);
	}

	@Override
	public IntValue evaluate() {		
		return ((IntLiteral)value).evaluate().Negation();
	}

	@Override
	public Boolean typeCorrect(Error e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
