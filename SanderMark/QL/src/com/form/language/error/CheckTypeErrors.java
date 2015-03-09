package com.form.language.error;

import java.util.Iterator;

import com.form.language.ast.Form;
import com.form.language.ast.statement.Statement;
import com.form.language.memory.TypeMemory;

public class CheckTypeErrors {
	//TODO: change flow to enforce checked types
	public static Boolean containsErrors(Form form){
		TypeMemory mem = new TypeMemory();
		form.getTypes(mem);
		return mem.hasErrors();
//	    Iterator<Statement> formIter = form.iterator();
//		while(formIter.hasNext()){
//			Boolean hasErrors = formIter.next().getType().isErrorType();
//			if(hasErrors){
//				return true;
//			}
//		}
//		return false;
	}
}
