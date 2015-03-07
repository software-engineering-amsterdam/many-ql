package com.form.language.ast.values;

import com.form.language.memory.RuntimeMemory;

public abstract class GenericValue<T>	 {
	public abstract void addToMemory(String key, RuntimeMemory m);
	public abstract String toString();
}
