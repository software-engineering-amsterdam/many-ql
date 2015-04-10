package qlProject.typeChecking.complaints.expression_level_complaint;

import java.util.Map;

import qlProject.ast.expression.IExpression;
import qlProject.ast.statement.assignment.Assignment;
import qlProject.ast.type.Type;
import qlProject.typeChecking.complaints.Complaint;
import qlProject.util.QuestionDetails;


public class ExpressionTypeError implements Complaint {

	private Map<String, QuestionDetails> questionsDetails;
	private String errorMessage;

	public ExpressionTypeError(Map<String, QuestionDetails> questionsDetails, Assignment q, IExpression e, Type t){
		this.questionsDetails = questionsDetails;
		setMessage(q, e, t);
	}

	public void setMessage(Assignment q, IExpression e, Type t){
		errorMessage = "Expression type error: the type of question: " + q.getId() +
				" is defined as " + questionsDetails.get(q.getId()).getType().toString() + " but is assigned a computed expression of type: " +
				t.toString();
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}

	@Override
	public void presentComplaint() {
		System.out.println(errorMessage);
	}

}