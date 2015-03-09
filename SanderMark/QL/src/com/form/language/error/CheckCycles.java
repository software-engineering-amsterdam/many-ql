package com.form.language.error;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.form.language.ast.Form;
import com.form.language.ast.statement.Statement;
import com.form.language.memory.IdCollector;

public class CheckCycles {
	//TODO: change flow to enforce checked types
	public static ErrorCollector containsCycles(Form form){
		ErrorCollector result = new ErrorCollector();
	    Iterator<Statement> formIter = form.iterator();
	    Map<Statement, IdCollector> referenceMap = new HashMap<Statement, IdCollector>();
		while(formIter.hasNext()){
			Statement s = formIter.next();
			IdCollector references = new IdCollector();
			s.getReferences(references);
			referenceMap.put(s, references);
		}
		return result;
	}
}
