package uva.sc.logic;

import java.util.List;

import uva.sc.ast.INodeVisitor;

public class If_Statement extends Statement {
	
	Expression expr;
	List<Question> questions;
	
	public If_Statement(Expression expr, List<Question> questions) {
		this.expr = expr;
		this.questions = questions;
	}
	
	public Expression getExpr() {
		return expr;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public String toString() {
		String result = "[IF] (";
		if (this.expr != null) {
			result += this.expr.toString() + ") THEN {";
		}
		for (int i = 0 ; i < this.questions.size() ; i++) {
			result += questions.get(i).toString() + "," ;
		}
		return result +"}";
	}

	@Override
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
