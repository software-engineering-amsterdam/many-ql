package uva.sc.logic;

import java.util.List;

public class If_Statement extends Statement {
	
	Expression expr;
	List<Question> questions;
	
	public If_Statement(Expression expr, List<Question> questions) {
		this.expr = expr;
		this.questions = questions;
	}
	
	public String toString() {
		String result = "";
		if (this.expr != null)
			result += this.expr.toString();
		for (int i = 0 ; i < this.questions.size() ; i++)
			result += questions.get(i).toString();
		return result;
	}

}
