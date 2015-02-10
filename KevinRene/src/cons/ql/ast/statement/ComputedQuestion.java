package cons.ql.ast.statement;

import cons.ql.ast.expression.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

public class ComputedQuestion<T extends QLType<T>> extends Question<T> {
	private Expression expr;
	
	public ComputedQuestion(QLIdent identifier, T type, QLString text, Expression expr) {
		super(identifier, type, text);
		this.expr = expr;
	}

	@Override
	public String show() {
		return "Assignment";
	}
	
	public Expression getExpr() {
		return this.expr;
	}
}
