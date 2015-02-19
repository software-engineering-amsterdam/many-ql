package uva.TaxForm.AST;

public class Question extends Node {
	
	private String name;
	private String label;
	private QuestionType type;
	private Expression expression;	//TODO: implement Expression
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public int getLevel() {
		return super.getLevel();
	}

	public void setLevel(int level) {
		super.setLevel(level);
	}
}
