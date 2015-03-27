package com.form.language.ast.expression.variable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReferenceCollection implements Iterable<Reference>{

    private List<Reference> ids;

    public ReferenceCollection() {
	ids = new ArrayList<Reference>();
    }

    public void addId(Reference reference) {
	ids.add(reference);
    }

    public boolean containsId(String id) {
	return ids.contains(id);
    }

    public Iterator<Reference> iterator() {
	return ids.iterator();
    }

    public String toString() {
	String result = "";
	for (Reference id : ids) {
	    result += id.getName() + "-->" + id.showTokenInfo() + "\n";
	}
	return result;
    }

}
