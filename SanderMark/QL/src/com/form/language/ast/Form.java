package com.form.language.ast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.statement.Statement;
import com.form.language.memory.Context;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

public class Form  {
	public String id;
	public List<Statement> statementList;
		
	public Form(String id) {
		this.id = id;
		this.statementList = new ArrayList<Statement>();
	}
	
	public Form(String id, List<Statement> statementList) {
		this.id = id;
		this.statementList = statementList;
	}
	
	public void getTypes(Context mem){
		for(Statement s: statementList){
			s.getType(mem);
		}
	}
	public void collectIds(IdCollector idCollector){
		for(Statement s: statementList){
			s.collectIds(idCollector);			
		}
	}
	
	public Iterator<Statement> iterator(){
		return statementList.iterator();
	}
	
	public Context initMemory(Context mem)
	{
		for(Statement s: statementList)
		{
			s.initMemory(mem);			
		}
		return mem;		
	}

	public void showTypes(Context mem) {
		for(Statement s: statementList){
			System.out.println(s.getType(mem));	
		}
	}
	
	public void setTypes(IdTypeTable ids){
		for(Statement s: statementList){
			s.setType(ids);
		}
	}
}
