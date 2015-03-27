package com.form.language.ast.expression.math;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.UnaryExpression;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class Negation extends UnaryExpression  {

    public Negation(Expression value, QLToken tokenInfo) {
	super(value, tokenInfo);
    }

    @Override
    public GenericValue evaluate(Context context) {
	return new IntValue(-((IntValue) value.evaluate(context)).getValue());
    }

    @Override
    public Type getType(Context context) {
	Type childType = value.getType(context);
	if (childType.isIntType()) {
	    return new IntType();
	} else {
	    if (!childType.isErrorType()) {
		context.addError(new Error(tokenInfo, "Expected -Int, but found -" + childType));
	    }
	    return new ErrorType();
	}
    }
}
