package com.form.language.ast.statement;

public class Question extends Statement {
	public String questionLabel;
	public String id;
	public String type;
	
	public Question(String questionLabel, String id, String type) {
		super();
		this.questionLabel = questionLabel;
		this.id = id;
		this.type = type;
	}
}
