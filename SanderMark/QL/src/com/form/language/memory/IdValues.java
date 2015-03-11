package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.values.GenericValue;

public class IdValues {
	private Map<String, GenericValue<?>> values;

	public IdValues() {
		this.values = new HashMap<String, GenericValue<?>>();
	}
	
	public void put(String idName, GenericValue<?> value){
		this.values.put(idName, value);
	}
	
	public String toString(){
		String result = "\nMemory:\n";
		for(String key: this.values.keySet()){
			result += key + ":" + this.values.get(key).toString() + "\n";
		}
		return result;
	}

	public GenericValue<?> get(String idName) {
		return this.values.get(idName);
	}
}
