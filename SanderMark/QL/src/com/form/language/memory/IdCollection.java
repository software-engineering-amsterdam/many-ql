package com.form.language.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.expression.variable.Reference;

public class IdCollection implements Iterable<Reference>{

    private List<Reference> ids;

    public IdCollection() {
	ids = new ArrayList<Reference>();
    }

    public void addId(Reference reference) {
	ids.add(reference);
    }

    public int showMemory() {
	return this.ids.size();
    }

    public boolean containsId(String id) {
	for (Reference i : this.ids) {
	    if (i.getName().equals(id)) {
		return true;
	    }
	}
	return false;
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
