package qlProject.util;

import qlProject.ast.statement.assignment.Assignment;
import qlProject.ast.type.Type;
import qlProject.ast.value.Value;

public class QuestionDetails {

	public Assignment question;
	public String questionText;
	public Type type;
	public Value value;

	public QuestionDetails(Assignment question, String id, String questionText, Type type, Value value) {
		this.question = question;
		this.questionText = questionText;
		this.type = type;
		this.value = value;
	}

	public Assignment getQuestion(){
		return question;
	}

	public String getQuestionText(){
		return questionText;
	}
	
	public Type getType(){
		return type;
	}
	
	public Value getValue(){
		return value;
	}

}