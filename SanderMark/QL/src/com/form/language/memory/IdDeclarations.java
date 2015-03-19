package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.statement.Question;

public class IdDeclarations {
    private Map<String, Question> declarations;

    public IdDeclarations() {
	this.declarations = new HashMap<String, Question>();
    }

    public void put(String name, Question declaration) {
	this.declarations.put(name, declaration);
    }

    public Question get(String name) {
	return this.declarations.get(name);
    }


}
