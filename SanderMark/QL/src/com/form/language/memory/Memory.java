package com.form.language.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;

public class Memory {
	
	private static HashMap<String,Type> ids;
	//private HashMap<String,GenericValue> values;
	//private List<String> labels;
			
	public Memory()
	{
		ids = new HashMap<String, Type>();
		//values = new HashMap();
		//labels = new List();
	}
	
	public static boolean Exists(String id)
	{
		return ids.containsKey(id);		
	}
	public static void addId(String id,Type type)
	{
		System.out.println(ids.size());
		if(!Exists(id))
		{
			ids.put(id, type);
		}
		else
		{			
			//Add error		
		}
	}
	public Type getType(String id)
	{
		return ids.get(id).getType();
	}

}
