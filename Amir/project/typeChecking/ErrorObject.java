package project.typeChecking;

public class ErrorObject {
	public String errorMessage;
	public String location;
	
	public ErrorObject (String errorMessage, String location){
		this.errorMessage = errorMessage;
		this.location = location;
	}

	public ErrorObject (String errorMessage){
		this.errorMessage = errorMessage;
	}
}
