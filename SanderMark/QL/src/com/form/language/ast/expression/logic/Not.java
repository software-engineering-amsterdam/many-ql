package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class Not extends UnaryExpression  {

    public Not(Expression value, QLToken tokenInfo) {
	super(value, tokenInfo);
    }

    @Override
    public BoolValue evaluate(Context context) {
	return new BoolValue(!((BoolValue) value.evaluate(context)).getValue());
    }

    @Override
    public Type getType(Context context) {
	Type childType = value.getType(context);
	if (childType.getType().isBoolType()) {
	    return new BoolType();
	} else {
	    if (!childType.isErrorType()) {
		context.addError(new Error(tokenInfo, "Expected !Boolean, but found !" + childType));
	    }
	    return new ErrorType();
	}
    }
}
