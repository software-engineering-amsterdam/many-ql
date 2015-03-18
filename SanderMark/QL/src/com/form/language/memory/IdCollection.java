package com.form.language.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.form.language.ast.expression.literal.IdLiteral;

public class IdCollection {

    private List<IdLiteral> ids;

    public IdCollection() {
	ids = new ArrayList<IdLiteral>();
    }

    public void addId(IdLiteral idLiteral) {
	ids.add(idLiteral);
    }

    public int showMemory() {
	return this.ids.size();
    }

    public boolean containsId(String id) {
	for (IdLiteral i : this.ids) {
	    i.IsReference();
	    if (i.getName().equals(id)) {
		return true;
	    }
	}
	return false;
    }

    public List<IdLiteral> getList() {
	return ids;
    }

    public Iterator<IdLiteral> iterator() {
	return ids.iterator();
    }

    public String toString() {
	String result = "";
	for (IdLiteral id : ids) {
	    result += id.getName() + "-->" + id.showTokenInfo() + "\n";
	}
	return result;
    }

}
