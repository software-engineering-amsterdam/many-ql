package uva.TaxForm.AST;

public class QuestionTypeMoney extends QuestionType {

	private float value;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Float.parseFloat(value);
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
