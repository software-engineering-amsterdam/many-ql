package nl.uva.se.interpretation;

import nl.uva.se.interpretation.error.ErrorList;

public class Result<T> {

	private ErrorList errorList;
	private T result;
	
	public Result(ErrorList errorList, T result) {
		this.errorList = errorList;
		this.result = result;
	}

	public ErrorList getErrorList() {
		return errorList;
	}

	public T getResult() {
		return result;
	}
	
}
