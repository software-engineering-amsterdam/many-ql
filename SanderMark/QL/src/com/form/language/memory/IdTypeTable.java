package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.variable.Reference;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;

public class IdTypeTable {
    private Map<String, Reference> idMap;

    public IdTypeTable(IdCollection idList) {
	this.idMap = new HashMap<String, Reference>();
	for (Reference id : idList.getList()) {
	    if (!id.IsReference()) {
		this.idMap.put(id.getName(), id);
	    }
	}
    }

    public Type getType(String name) {
	if (idMap.containsKey(name)) {
	    return idMap.get(name).getType(null);
	}
	return new ErrorType();
    }

    public String toString() {
	String result = "";
	for (String key : this.idMap.keySet()) {
	    result += key + ":" + idMap.get(key).getType(null) + "\n";
	}
	return result;
    }
}