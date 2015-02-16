package cons.ql.ast.statement;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

@SuppressWarnings("rawtypes")
public class ComputedQuestion extends Question {
	private Expression expression;
	
	@SuppressWarnings("unchecked")
	public ComputedQuestion(QLIdent identifier, QLType type, QLString text, Expression expression) {
		super(identifier, type, text);		
		this.expression = expression;		
		type.setValue(expression);
	}

	public Expression getExpression() {
		return this.expression;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ComputedQuestion(");
		
		sb.append(identifier.toString() + ", ");
		sb.append(type.toString() + ", ");
		sb.append(questionText.toString() + ", ");
		sb.append(expression.toString());
		sb.append(")");
		
		return sb.toString();
	}	
}