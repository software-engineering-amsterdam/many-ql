package com.form.language.ast.expression.math;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class Multiplication extends BinaryExpression {

    public Multiplication(Expression left, Expression right, QLToken tokenInfo) {
	super(left, right, tokenInfo);
    }

    @Override
    public GenericValue evaluate(Context context) {
	return new IntValue(((IntValue) left.evaluate(context)).getValue() * ((IntValue) right.evaluate(context)).getValue());
    }

    @Override
    public Type getType(Context context) {
	Type leftType = left.getType(context);
	Type rightType = right.getType(context);
	if (leftType.isIntType() && rightType.isIntType()) {
	    return new IntType();
	} else {
	    if (!(leftType.isErrorType() || rightType.isErrorType())) {
		context.addError(new Error(tokenInfo, "Expected Int * Int, but found " + leftType + " * " + rightType));
	    }
	    return new ErrorType();
	}
    }
}
