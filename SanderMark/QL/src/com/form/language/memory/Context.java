package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;
import com.form.language.gui.components.QuestionComponent;

public class Context {
	private Map<String, GenericValue<?>> memory;
	
	private Map<String, List<Expression>> IdDependencies; 
	
	private Map<Expression, List<QuestionComponent>> ifConditions; 	
	
	private IdCollector references;
	private Map<String, IdLiteral> declarations;
	private ErrorCollector errors;
	
	public Context(){
		this.memory = new HashMap<String, GenericValue<?>>();
		this.ifConditions = new HashMap<Expression, List<QuestionComponent>>();
		this.IdDependencies = new HashMap<String, List<Expression>>();
		this.references = new IdCollector();
		this.declarations = new HashMap<String, IdLiteral>();
		this.errors = new ErrorCollector();
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
			List<Expression> tempList = this.IdDependencies.get(key.name);
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
		List<Expression> dependencies = IdDependencies.get(id);
		if (dependencies == null){
			List<Expression> emptyList = new ArrayList<Expression>();
			return emptyList.iterator();
		}
		else {
			return dependencies.iterator();		
		}
	}
	
	public GenericValue<?> getValue(String s){
		return this.memory.get(s);
	}
	
	public void addId(IdLiteral id){
		if(id.IsReference()){
			this.references.addId(id);
		}
		this.declarations.put(id.name, id);
	}
	
	public Boolean hasErrors(){
		return !errors.isEmpty();
	}
	public Type getIdType(IdLiteral id){
		IdLiteral declaration = this.declarations.get(id.name);
		if(declaration == null){
			this.addError(new Error(id.tokenInfo, "Undeclared variable reference"));
			return new ErrorType();
		}
		return declaration.getType(this);
	}
	
	public void addError(Error e){
		this.errors.add(e);
	}
	
	public String getErrors(){
		return errors.toString();
	}
}
