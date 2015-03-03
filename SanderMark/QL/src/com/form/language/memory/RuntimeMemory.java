package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.values.GenericValue;

public class RuntimeMemory {
	private Map<String, Integer> intMemory;
	private Map<String, String> stringMemory;
	private Map<String, Boolean> boolMemory;
	private Map<String, GenericValue<?>> genMemory;

	public RuntimeMemory(){
		this.intMemory = new HashMap<String, Integer>();
		this.stringMemory = new HashMap<String, String>();
		this.boolMemory = new HashMap<String, Boolean>();
	}
	
	public void put(String key, String value){
		this.stringMemory.put(key, value);
	}
	
	public void put(String key, Boolean value){
		this.boolMemory.put(key, value);
	}
	
	public void put(String key, Integer value){
		this.intMemory.put(key, value);
	}
	
	public String toString(){
		String result = "";
		result += "\nintMemory: \n";
		for(String key: intMemory.keySet()){
			result += key + ":" + intMemory.get(key).toString() + "\n";
		}

		result += "\nstringMemory: \n";
		for(String key: stringMemory.keySet()){
			result += key + ":" + stringMemory.get(key).toString() + "\n";
		}
		
		result += "\nboolMemory:\n";
		for(String key: boolMemory.keySet()){
			result += key + ":" + boolMemory.get(key).toString() + "\n";
		}
		return result;
	}
	
	public Boolean getBool(String s){
		return this.boolMemory.get(s);
	}
	
	public String getString(String s){
		return this.stringMemory.get(s);
	}
	
	public Integer getInt(String s){
		return this.intMemory.get(s);
	}
	
	public GenericValue<?> getValue(String s){
		return this.genMemory.get(s);
	}
}
