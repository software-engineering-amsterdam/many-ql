package com.form.language.error;

import java.util.Iterator;

import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.Type;
import com.form.language.memory.IdCollection;
import com.form.language.memory.IdTypeTable;

public class CheckVariableErrors {
	public static ErrorCollector containsUndeclaredVariables(IdCollection ids, IdTypeTable types){
		ErrorCollector resultErrors = new ErrorCollector();
	    Iterator<IdLiteral> idIter = ids.iterator();
		while(idIter.hasNext()){
			IdLiteral id = idIter.next();
			Type idDeclared = types.getType(id.name);
			if(idDeclared.isErrorType()){
				resultErrors.add(new Error(id.tokenInfo,"The variable " + id.name +" is not declared"));
			}
		}
		return resultErrors;
	}
}
