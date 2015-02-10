package cons.ql.ast.statement;

import cons.ql.ast.expression.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

public class ComputedQuestion<T extends QLType<T>> extends Question<T> {
	private Expression expr;
	
	public ComputedQuestion(QLIdent identifier, T type, QLString text, T expr) {
		super(identifier, type, text);
		this.expr = expr;
		if(type.getName() != expr.getName())
			System.out.println("Idiot, the two things don't match");
		type.setValue(expr);
	}

	@Override
	public String show() {
		return "ComputedQuestion";
	}
	
	public Expression getExpr() {
		return this.expr;
	}
}
