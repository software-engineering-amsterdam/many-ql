package uva.sc.logic;

import java.util.List;

public class If_Statement extends Statement {
	
	Expression expr;
	List<Question> questions;
	
	public If_Statement(Expression expr, List<Question> questions) {
		this.expr = expr;
		this.questions = questions;
	}

}
