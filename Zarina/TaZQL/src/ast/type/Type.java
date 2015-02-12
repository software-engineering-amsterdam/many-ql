package ast.type;


public class Type  {
	private String type;
	
	public Type(String type) {
		this.type = type;
	}
	
	public String getTYPE() {
		return type;
	}
/*
	@Override
	public String toString() {
		return id;
	}
*/	/*
	@Override
	public <T> T accept(IMainVisitor<T> visitor) {
		return visitor.visit(this);
	}
	*/
}
