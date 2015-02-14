package ast.question;


public abstract class Id extends IQuestionVisitable {

	private String id;
	
	public Id(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

}

