package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class NotEqual extends BinaryExpression {

    public NotEqual(Expression left, Expression right, QLToken tokenInfo) {
	super(left, right, tokenInfo);
    }

    @Override
    public BoolValue evaluate(Context context) {
	return new BoolValue(!left.evaluate(context).equals(right.evaluate(context)));
    }

    public Type getType(Context context) {
	Type leftType = left.getType(context);
	Type rightType = right.getType(context);

	if (leftType.equals(rightType)) {
	    return new BoolType();
	}
	if (!(leftType.isErrorType() || rightType.isErrorType())) {
		context.addError(new Error(tokenInfo, "Cannot compare unequal types: " + leftType + " != " + rightType));
	    }
	return new ErrorType();
    }
}