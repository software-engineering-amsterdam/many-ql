package qlProject.typeChecking.complaints.expression_level_complaint.operation_error;

import qlProject.ast.expression.IExpression;
import qlProject.ast.type.Type;
import qlProject.typeChecking.complaints.Complaint;

public class EqualityOperationError implements Complaint {

	String errorMessage;

	public EqualityOperationError(IExpression eLeft, IExpression eRight, Type typeLeft, Type typeRight){
		setMessage(eLeft, eRight, typeLeft, typeRight);
	}

	public void setMessage(IExpression eLeft, IExpression eRight, Type typeLeft, Type typeRight){
		errorMessage = "EqualityOperation error: the left hand sub-expression " + 
				eLeft.toString() + " of the type " + typeLeft.toString() +
				"cannot be evaluated for (in)equality with the right hand sub-expression "+
				eRight.toString() + " of the type " + typeRight.toString();
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}

	@Override
	public void presentComplaint() {
		System.out.println(errorMessage);
		// TODO Auto-generated method stub

	}
}