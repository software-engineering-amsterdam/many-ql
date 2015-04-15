package qlProject.typeChecking.complaints.expression_level_complaint.operation_error;

import qlProject.ast.expression.IExpression;
import qlProject.ast.type.Type;
import qlProject.typeChecking.complaints.Complaint;

public class OperationError implements Complaint {

	String errorMessage;

	public OperationError(IExpression e, Type actualT, Type expectedT){
		setMessage(e, actualT, expectedT);
	}

	public void setMessage(IExpression e, Type actualType, Type expectedT){
		errorMessage = "Operation error: the expression " + e.toString() + "seems to be of type "+
				actualType.toString() +" but was expected to be of type: " + expectedT.toString();
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