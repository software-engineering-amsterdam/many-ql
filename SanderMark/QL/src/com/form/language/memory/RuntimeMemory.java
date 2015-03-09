package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.components.QuestionComponent;

public class RuntimeMemory {
	private Map<String, GenericValue<?>> memory;
	
	private Map<String, List<Expression>> IdDependencies; 
	
	private Map<Expression, List<QuestionComponent>> ifConditions; 	

	public RuntimeMemory(){
		this.memory = new HashMap<String, GenericValue<?>>();
		this.ifConditions = new HashMap<Expression, List<QuestionComponent>>();
		this.IdDependencies = new HashMap<String, List<Expression>>();
	}
	
	public void putExp(Expression key,QuestionComponent value)
	{
		List<QuestionComponent> tempList = this.ifConditions.get(key);
		if(tempList != null)
		{
			tempList.add(value);
		}
		else
		{
			tempList = new ArrayList<QuestionComponent>();
			tempList.add(value);
		}
		this.ifConditions.put(key, tempList);
	}
	
	public void putDependencie(IdCollector keyCollection, Expression value)
	{
		Iterator<IdLiteral> iterator = keyCollection.iterator();
		while(iterator.hasNext())
		{
			IdLiteral key = iterator.next();
			List<Expression> tempList = this.IdDependencies.get(key);
			if(tempList != null)
			{
				tempList.add(value);
			}
			else
			{
				tempList = new ArrayList<Expression>();
				tempList.add(value);
			}
			this.IdDependencies.put(key.name, tempList);		
		}
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
	
	public List<QuestionComponent> getQcomponent(Expression exp)
	{
		return this.ifConditions.get(exp);		
	}
	
	public Iterator<Expression> getExpressions(String id)
	{
		/*Iterator<Expression> expList = new Iterator<Expression>();
		for ( Expression key : this.ifConditions.keySet() ) {
		    expList.add(key);
		}*/
		return IdDependencies.get(id).iterator();		
	}
	
	public GenericValue<?> getValue(String s){
		return this.memory.get(s);
	}
}
