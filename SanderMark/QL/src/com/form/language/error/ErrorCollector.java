package com.form.language.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorCollector {
	private List<Error> errorList;
	
	public ErrorCollector(){
		this.errorList = new ArrayList<Error>();
	}
	
	public ErrorCollector(ErrorCollector left, ErrorCollector right){
		ArrayList<Error> combinedList = new ArrayList<Error>(left.errorList);
		combinedList.addAll(right.errorList);
		
		this.errorList = combinedList;
	}
	
	public void add(Error e){
		errorList.add(e);
	}
	
	public Iterator<Error> getErrorCollection(){
		return errorList.iterator();
	}
	
	public void print(){
		Iterator<Error> iter = errorList.iterator();
		while(iter.hasNext()){
			System.err.println(iter.next());
		}
	}
}
