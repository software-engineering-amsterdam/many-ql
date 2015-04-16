package qlProject.typeChecking.complaints.expression_level_complaint;

import qlProject.typeChecking.complaints.Complaint;


public class CyclicReferenceError implements Complaint {

	private String errorMessage;
	
	public CyclicReferenceError(String id) {
		setMessage(id);
	}

	private void setMessage(String id) {
		errorMessage = "Cyclic reference error: question \"" + id + "\" is directly/indirectly refering to itself"; 
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
