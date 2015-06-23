package qlProject.typeChecking.complaints.statement_level_complaint;

import qlProject.typeChecking.complaints.Complaint;


public class DuplicateLabelsWarning implements Complaint {

	String warningMessage;

	public DuplicateLabelsWarning(String label){
		setWarningMessage(label);
	}

	public void setWarningMessage(String label){
		
		warningMessage = "Label warning: the label " + label + 
				" already exists!";
	}

	@Override
	public String getMessage() {
		return warningMessage;
	}

	@Override
	public void presentComplaint() {
		System.out.println(warningMessage);
		// TODO Auto-generated method stub
		
	}
}