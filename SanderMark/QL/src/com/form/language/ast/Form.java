package com.form.language.ast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.form.language.ast.statement.Statement;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

public class Form  {
	public String id;
	public List<Statement> statementList;
	private JPanel fPanel;
		
	public Form(String id) {
		this.id = id;
		this.statementList = new ArrayList<Statement>();
	}
	
	public Form(String id, List<Statement> statementList) {
		this.id = id;
		this.statementList = statementList;
	}
	
	public void getErrors(ErrorCollector errs){
		for(Statement s: statementList){
			s.getErrors(errs);
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
	
	public RuntimeMemory initMemory()
	{
		RuntimeMemory mem = new RuntimeMemory();
		for(Statement s: statementList)
		{
			s.initMemory(mem);			
		}
		return mem;		
	}

	public void showTypes() {
		for(Statement s: statementList){
			System.out.println(s.getType());	
		}
	}
	
	public void setTypes(IdTypeTable ids){
		for(Statement s: statementList){
			s.setType(ids);
		}
	}
}
