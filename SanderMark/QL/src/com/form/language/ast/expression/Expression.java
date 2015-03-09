package com.form.language.ast.expression;

import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

public interface Expression {
	public abstract Type getType(Context context);
//	public abstract void getErrors(ErrorCollector errorCollector);
	public abstract void collectIds(IdCollector idCollector);
	public abstract Boolean isCorrectlyTyped(Context context);
	public abstract String showTokenInfo();
	public abstract void setType(IdTypeTable ids);
	public abstract GenericValue<?> evaluate(Context context);
	public abstract void getReferences(IdCollector idCollector);
}