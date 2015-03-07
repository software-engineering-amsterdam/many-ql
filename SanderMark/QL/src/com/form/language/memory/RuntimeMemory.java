package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.values.GenericValue;

public class RuntimeMemory {
	private Map<String, GenericValue<?>> memory;

	public RuntimeMemory(){
		this.memory = new HashMap<String, GenericValue<?>>();
	}
	
	public void put(String key, GenericValue<?> value){
		this.memory.put(key, value);
	}
	
	public String toString(){
		String result = "\nMemory:\n";
		for(String key: memory.keySet()){
			result += key + ":" + memory.get(key).toString() + "\n";
		}
		return result;
	}
	
	public GenericValue<?> getValue(String s){
		return this.memory.get(s);
	}
}
