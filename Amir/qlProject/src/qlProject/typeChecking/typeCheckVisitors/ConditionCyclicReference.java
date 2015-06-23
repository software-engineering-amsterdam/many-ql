package qlProject.typeChecking.typeCheckVisitors;

import qlProject.ast.expression.IExpression;
import qlProject.typeChecking.complaints.Complaint;

public class ConditionCyclicReference implements Complaint {

	String errorMessage;

	public ConditionCyclicReference(IExpression e, String observer){
		setMessage(e, observer);
	}

	public void setMessage(IExpression e, String obserever){
		errorMessage = "Condition cyclic reference error: the condition "+ "" + 
		"is directl\\indirectly refering to at least one question that has it as a condition";
	}


	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void presentComplaint() {
		// TODO Auto-generated method stub

	}

}
