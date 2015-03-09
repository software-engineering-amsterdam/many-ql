package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.components.QuestionComponent;

public class RuntimeMemory {
	private Map<String, GenericValue<?>> memory;
	
	private Map<Expression, QuestionComponent> ifConditions; 

	public RuntimeMemory(){
		this.memory = new HashMap<String, GenericValue<?>>();
		this.ifConditions = new HashMap<Expression, QuestionComponent>();
	}
	
	public void putExp(Expression key,QuestionComponent value)
	{
		this.ifConditions.put(key, value);
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
	
	public QuestionComponent getQcomponent(Expression exp)
	{
		return this.ifConditions.get(exp);		
	}
	
	public ArrayList<Expression> getExpressions()
	{
		ArrayList<Expression> expList = new ArrayList<Expression>();
		for ( Expression key : this.ifConditions.keySet() ) {
		    expList.add(key);
		}
		return expList;		
	}
	
	public GenericValue<?> getValue(String s){
		return this.memory.get(s);
	}
}
