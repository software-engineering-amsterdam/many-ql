package com.form.language.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.expression.literal.IdLiteral;

public class IdCollector {
	
	private List<IdLiteral> ids;
	//private HashMap<String,GenericValue> values;
	//private List<String> labels;
			
	public IdCollector()
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
			if(i.name.equals(id))		
			{
				return true;
			}
		}
		return false;
	}
	
	public List<IdLiteral> getList(){
		return ids;
	}
	
	public Iterator<IdLiteral> iterator(){
		return ids.iterator();
	}

}
