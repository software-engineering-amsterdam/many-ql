package cons.ql.ast.statement;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

@SuppressWarnings("rawtypes")
public class ComputedQuestion extends Question {
	private final int EXPRESSION = 3;
	
	@SuppressWarnings("unchecked")
	public ComputedQuestion(QLIdent identifier, QLType type, QLString text, Expression expression) {
		super(identifier, type, text);		
		this.members.add(expression);		
		type.setValue(expression);
	}

	public Expression getExpression() {
		return (Expression) this.members.get(EXPRESSION);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ComputedQuestion(");
		
		sb.append(getIdent().toString() + ", ");
		sb.append(getType().toString() + ", ");
		sb.append(getText().toString());
		sb.append(getExpression().toString());
		sb.append(")");
		
		return sb.toString();
	}	
}