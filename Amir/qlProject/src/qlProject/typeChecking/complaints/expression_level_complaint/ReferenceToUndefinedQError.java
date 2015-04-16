package qlProject.typeChecking.complaints.expression_level_complaint;

import qlProject.typeChecking.complaints.Complaint;

public class ReferenceToUndefinedQError implements Complaint {

	String errorMessage;

	public ReferenceToUndefinedQError(String id){
		setMessage(id);
	}

	public void setMessage(String id){
		errorMessage = "reference to undefined question error: the identifier: " + id + " is undefined";
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