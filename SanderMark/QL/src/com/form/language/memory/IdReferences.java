package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IdLiteral;

public class IdReferences {
    private Map<String, List<Expression>> referenceMap;

    public IdReferences() {
	this.referenceMap = new HashMap<String, List<Expression>>();
    }

    public List<Expression> get(String key) {
	if (referenceMap.containsKey(key)) {
	    return referenceMap.get(key);
	} else {
	    return new ArrayList<Expression>();
	}
    }

    public void put(String idName, List<Expression> dependencies) {
	this.referenceMap.put(idName, dependencies);
    }

    public void putAll(IdCollection keyCollection, Expression value) {
	Iterator<IdLiteral> iterator = keyCollection.iterator();
	while (iterator.hasNext()) {
	    IdLiteral key = iterator.next();
	    List<Expression> tempList;

	    if (this.referenceMap.containsKey(key.getName())) {
		tempList = this.referenceMap.get(key.getName());
	    } else {
		tempList = new ArrayList<Expression>();
	    }

	    tempList.add(value);
	    this.referenceMap.put(key.getName(), tempList);
	}
    }
}
