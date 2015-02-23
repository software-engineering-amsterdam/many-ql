package uva.sc.logic;


public class Question extends Statement{

	String str;
	String id;
	Type type;
	Expression expr;
	
	public Question(String str, String id, Type type, Expression expr) {
		this.str = str;
		this.id = id;
		this.type = type;
		this.expr = expr;
	}
}
