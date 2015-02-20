package uva.TaxForm.AST;

public class QuestionTypeBoolean extends QuestionType {

	private boolean value;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Boolean.parseBoolean(value);
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
