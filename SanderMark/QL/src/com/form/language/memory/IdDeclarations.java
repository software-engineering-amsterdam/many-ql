package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.variable.Reference;

public class IdDeclarations {
    private Map<String, Reference> declarations;

    public IdDeclarations() {
	this.declarations = new HashMap<String, Reference>();
    }

    public void put(String name, Reference declaration) {
	this.declarations.put(name, declaration);
    }

    public Reference get(String name) {
	return this.declarations.get(name);
    }

}
