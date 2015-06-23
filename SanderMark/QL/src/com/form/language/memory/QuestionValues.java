package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.values.GenericValue;

public class QuestionValues {
    private Map<String, GenericValue> values;

    public QuestionValues() {
	this.values = new HashMap<String, GenericValue>();
    }

    public void put(String string, GenericValue value) {
	values.put(string, value);
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
