package ast.form;

import java.util.List;

import ast.AST;
import ast.question.Question;

public class Form extends AST {
	private final String formId;
	private List<Question> arrayQuestions;
	
	
	public Form (String formId, List<Question> arrayQuestions) {
		this.formId = formId;
		this.arrayQuestions = arrayQuestions;
	}	
	
	public String getFormId(){
		return formId;
	}
	
	public List<Question> getQuestionText(){
		return arrayQuestions;
	}
	
	
	public <T> T accept(IFormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		String output = "FORM " +this.formId + " { ";
		for(Question q: arrayQuestions)
			output += q.toString() + "\n";
		output += " } END ";
		
		return output;
	}
}
