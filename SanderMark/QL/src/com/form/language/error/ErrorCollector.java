package com.form.language.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorCollector {
	private List<Error> errorList;
	
	public ErrorCollector(){
		this.errorList = new ArrayList<Error>();
	}
	
	public void add(Error e){
		errorList.add(e);
	}
	
	public Iterator<Error> getErrorCollection(){
		return errorList.iterator();
	}
	
	public List<String> print(){
		List<String> result = new ArrayList<String>();
		Iterator<Error> iter = errorList.iterator();
		while(iter.hasNext()){
			result.add(iter.next().toString());
		}
		return result;
	}
	
	@Override
	public String toString(){
		String result = "";
		Iterator<Error> iter = errorList.iterator();
		while(iter.hasNext()){
			result += iter.next() + "\n";
		}
		return result;
	}
	public Boolean isEmpty(){
		return errorList.isEmpty();
	}
}
