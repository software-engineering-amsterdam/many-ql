package uva.TaxForm.AST;

public class QuestionTypeInteger extends QuestionType {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = Integer.parseInt(value);
	}
}
