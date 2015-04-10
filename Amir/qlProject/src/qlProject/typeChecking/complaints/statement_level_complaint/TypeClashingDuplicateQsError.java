package qlProject.typeChecking.complaints.statement_level_complaint;

import qlProject.ast.statement.assignment.Assignment;
import qlProject.typeChecking.complaints.Complaint;

public class TypeClashingDuplicateQsError implements Complaint {

	String errorMessage;

	public TypeClashingDuplicateQsError(Assignment introducedQ, Assignment existingQ){
		setMessage(introducedQ, existingQ);
	}

	public void setMessage(Assignment introducedQ, Assignment existingQ){
		errorMessage = "Type clash error: the question " + introducedQ.getId() + 
				" cannot be redeclared as type \"" + introducedQ.getType().toString() + 
				"\", but is already declared as type \"" + existingQ.getType().toString();
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