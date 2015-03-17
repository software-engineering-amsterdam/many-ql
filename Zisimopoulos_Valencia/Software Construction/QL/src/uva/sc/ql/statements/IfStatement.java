package uva.sc.ql.statements;

import java.util.List;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.expression.Expression;

public class IfStatement implements Statement {

    Expression expr;
    List<Question> questions;

    public IfStatement(Expression expr, List<Question> questions) {
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
	for (int i = 0; i < this.questions.size(); i++) {
	    result += questions.get(i).toString() + ",";
	}
	return result + "}";
    }

    public <T> T accept(IQLStatementNodeVisitor<T> visitor) {
	return visitor.visit(this);
    }

}
