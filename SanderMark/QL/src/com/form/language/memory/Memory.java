package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.type.Type;

public class Memory {
	
	private Map<String,Type> ids;
	//private HashMap<String,GenericValue> values;
	//private List<String> labels;
			
	public Memory()
	{
		ids = new HashMap<String, Type>();
		//values = new HashMap();
		//labels = new List();
	}
	
	public boolean Exists(String id)
	{
		return this.ids.containsKey(id);		
	}
	public void addId(String id,Type _type)
	{
		System.out.println(this.ids.size());
		if(!Exists(id))
		{
			this.ids.put(id, _type);
		}
		else
		{			
			//Add error		
		}
		System.out.println(this.ids.size());
	}
	public Type getType(String id)
	{
		return ids.get(id);
	}

}
