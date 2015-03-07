package com.form.language.memory;
import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.literal.*;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;

public class IdTypeTable {
	private Map<String, IdLiteral> idMap;

	public IdTypeTable(IdCollector idList) {
		this.idMap = new HashMap<String, IdLiteral>();
		for(IdLiteral id: idList.getList()){
			if(!id.IsReference()){
				this.idMap.put(id.name, id);
			}
		}
	}
	
	public Type getType(String name){
		if(idMap.containsKey(name)){
			return idMap.get(name).getType();
		}
		return new ErrorType();
	}
	
	public String toString(){
		String result = "";
		for(String key: this.idMap.keySet()){
			result += key + ":" + idMap.get(key).getType() + "\n";
		}
		return result;
	}
}