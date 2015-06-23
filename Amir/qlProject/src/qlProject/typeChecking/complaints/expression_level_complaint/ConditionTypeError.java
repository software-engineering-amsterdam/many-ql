package qlProject.typeChecking.complaints.expression_level_complaint;

import qlProject.ast.expression.IExpression;
import qlProject.ast.type.Type;
import qlProject.typeChecking.complaints.Complaint;


public class ConditionTypeError implements Complaint {

	private final String errorMessage;
	
	public ConditionTypeError(IExpression e, Type t){
		errorMessage = "Condition type error: the expression: " + e.toString() + 
				" is supposed to be a boolean expression, but it seems to be an expression of type " + t.toString();
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}

	@Override // TODO remove
	public void presentComplaint() {
		System.out.println(errorMessage);
	}

}
