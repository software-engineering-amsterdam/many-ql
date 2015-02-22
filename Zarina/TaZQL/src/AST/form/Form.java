package ast.form;

import java.util.ArrayList;

import ast.AST;
import ast.expression.variables.Id;
import ast.question.Question;

public class Form extends AST {
	private final Id formId;
	private ArrayList<Question> arrayQuestions;
	
	
	public Form (Id formId, ArrayList<Question> arrayQuestions) {
		this.formId = formId;
		this.arrayQuestions = arrayQuestions;
	}	
	
	public Id getFormId(){
		return formId;
	}
	
	public ArrayList<Question> getQuestionText(){
		return arrayQuestions;
	}
	

	public <T> T accept(IFormVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
