package com.form.language.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;

public class Memory {
	
	private HashMap<String,String> ids;
	//private HashMap<String,GenericValue> values;
	//private List<String> labels;
			
	public Memory()
	{
		ids = new HashMap<String, String>();
		//values = new HashMap();
		//labels = new List();
	}
	
	public boolean Exists(String id)
	{
		return this.ids.containsKey(id);		
	}
	public void addId(String id,String type)
	{
		System.out.println(this.ids.size());
		if(!Exists(id))
		{
			this.ids.put(id, type);
		}
		else
		{			
			//Add error		
		}
		System.out.println(this.ids.size());
	}
	public String getType(String id)
	{
		return ids.get(id);
	}

}
