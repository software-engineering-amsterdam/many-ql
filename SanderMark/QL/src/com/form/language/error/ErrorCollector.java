package com.form.language.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorCollector {
    private List<Error> errorList;

    public ErrorCollector() {
	this.errorList = new ArrayList<Error>();
    }

    public void add(Error e) {
	errorList.add(e);
    }

    public Iterator<Error> getErrorCollection() {
	return errorList.iterator();
    }

    public List<String> print() {
	List<String> result = new ArrayList<String>();
	for(Error e : errorList){
	    result.add(e.toString());
	}
	return result;
    }

    @Override
    public String toString() {
	String result = "";
	for(Error e : errorList)
	{
		result += e + "\n";
	}
	return result;
    }

    public Boolean isEmpty() {
	return errorList.isEmpty();
    }
}
