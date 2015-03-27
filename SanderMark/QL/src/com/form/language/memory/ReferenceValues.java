package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.values.GenericValue;

public class ReferenceValues {
    private Map<String, GenericValue> values;

    public ReferenceValues() {
	this.values = new HashMap<String, GenericValue>();
    }

    public void put(String idName, GenericValue value) {
	values.put(idName, value);
    }

    public String toString() {
	String result = "\nMemory:\n";
	for (String key : values.keySet()) {
	    result += key + ":" + values.get(key) + "\n";
	}
	return result;
    }

    public GenericValue get(String idName) {
	return values.get(idName);
    }
}
