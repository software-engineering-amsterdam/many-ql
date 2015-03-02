package com.form.language.memory;

import java.util.ArrayList;
import java.util.List;

import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.statement.Statement;

public class Memory {
	
	private List<IdLiteral> ids;
	//private HashMap<String,GenericValue> values;
	//private List<String> labels;
			
	public Memory()
	{
		ids = new ArrayList<IdLiteral>();
		//values = new HashMap();
		//labels = new List();
	}
	
	public void addId(IdLiteral idLiteral)
	{
		ids.add(idLiteral);
		System.out.println(this);
	}
	
	public int showMemory()
	{
		return this.ids.size();		
	}
	
	public boolean containsId(String id)
	{
		for(IdLiteral i: this.ids){
			if(i._value.equals(id))		
			{
				return true;
			}
		}
		return false;
	}

}
