package com.form.language.ast.values;

import com.form.language.memory.Context;

public abstract class GenericValue<T>	 {
	public abstract void addToMemory(String key, Context context);
	public abstract String toString();
}
