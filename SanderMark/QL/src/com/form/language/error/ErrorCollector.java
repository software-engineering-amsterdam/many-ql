package com.form.language.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorCollector {
	private static List<Error> errorList;
	
	public ErrorCollector(){
		ErrorCollector.errorList = new ArrayList<Error>();
	}
	
	public static void add(Error e){
		errorList.add(e);
	}
	
	public static Iterator<Error> getErrorCollection(){
		return errorList.iterator();
	}
	
	public void print(){
		Iterator<Error> iter = errorList.iterator();
		while(iter.hasNext()){
			System.err.println(iter.next());
		}
	}
}
