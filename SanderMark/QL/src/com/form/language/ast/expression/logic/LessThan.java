package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class LessThan extends BinaryExpression {

    public LessThan(Expression left, Expression right, QLToken tokenInfo) {
	super(left, right, tokenInfo);
    }

    @Override
    public BoolValue evaluate(Context context) {
	return new BoolValue(((IntValue) left.evaluate(context)).getValue() < ((IntValue) right.evaluate(context)).getValue());
    }

    @Override
    public Type getType(Context context) {
	Type leftType = left.getType(context);
	Type rightType = right.getType(context);
	if (leftType.isIntType() && rightType.isIntType()) {
	    return new BoolType();
	} else {
	    if (!(leftType.isErrorType() || rightType.isErrorType())) {
		context.addError(new Error(tokenInfo, "Expected Int < Int, but found " + leftType + " < " + rightType));
	    }
	    return new ErrorType();
	}
    }
}
