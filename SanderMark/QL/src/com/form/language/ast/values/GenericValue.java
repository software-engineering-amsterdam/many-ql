package com.form.language.ast.values;

import com.form.language.memory.Context;

public abstract class GenericValue {
    public abstract void addToMemory(String key, Context context);
    public abstract Boolean equals(GenericValue value);
    public abstract String toString();
}
