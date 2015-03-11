package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.literal.IdLiteral;

public class IdDeclarations {
	private Map<String, IdLiteral> declarations;

	public IdDeclarations() {
		this.declarations = new HashMap<String, IdLiteral>();
	}
	
	public void put(String name, IdLiteral declaration){
		this.declarations.put(name, declaration);
	}
	
	public IdLiteral get(String name){
		return this.declarations.get(name);
	}

}
