package com.form.language.error;

import com.form.language.ast.Form;
import com.form.language.memory.Context;

public class CheckTypeErrors {
	//TODO: change flow to enforce checked types
	public static Boolean containsErrors(Form form){
		Context context = new Context();
		form.getTypes(context);
		return context.hasErrors();
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
