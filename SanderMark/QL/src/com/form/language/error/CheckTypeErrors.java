package com.form.language.error;

import java.util.Iterator;

import com.form.language.ast.Form;
import com.form.language.ast.statement.Statement;

public class CheckTypeErrors {
	//TODO: change flow to enforce checked types
	public static Boolean containsErrors(Form form){
	    Iterator<Statement> formIter = form.iterator();
		while(formIter.hasNext()){
			Boolean hasErrors = formIter.next().getType().isErrorType();
			if(hasErrors){
				return true;
			}
		}
		return false;
	}
}
