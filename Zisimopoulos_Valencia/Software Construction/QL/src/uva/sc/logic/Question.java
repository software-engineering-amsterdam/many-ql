package uva.sc.logic;


public class Question extends Statement{

	String str;
	ID id;
	Type type;
	Expression expr;

	public Question(String str, ID id, Type type, Expression expr) {
		this.str = str;
		this.id = id;
		this.type = type;
		this.expr = expr;
	}

	public Question(String str, ID id, Type type) {
		this.str = str;
		this.id = id;
		this.type = type;
	}
	
	public String toString() {
		String result = "[String]: " + this.str + ", " + this.id.toString() + ", " + this.type.toString();
		if (this.expr != null)
			result += this.expr.toString();
		return result;		
	}
}
