package qlProject.ast.statement.assignment;

import qlProject.ast.statement.IStatement;
import qlProject.ast.type.Type;

public abstract class Assignment implements IStatement {

	private final String assignmentId;
	private final String assignmentText;
	private final Type type;

	public Assignment (String id, String text, Type type){
		this.assignmentId = id;
		this.assignmentText = text;
		this.type = type;
	}

	
	public Type getType(){
		return this.type;
	}

	public String getId() {
		return this.assignmentId;
	}

	public String getQuestionText() {
		return this.assignmentText;
	}

}