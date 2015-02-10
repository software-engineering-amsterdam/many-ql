package cons.ql.ast.statement;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

public class ComputedQuestion<T extends QLType<T>> extends Question<T> {
	private QLType<T> literal;
	
	public ComputedQuestion(QLIdent identifier, T type, QLString text, T literal) {
		super(identifier, type, text);		
		this.literal = literal;		
		type.setValue(literal);
	}

	public QLType<T> getExpression() {
		return this.literal;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ComputedQuestion(");
		
		sb.append(identifier.toString() + ", ");
		sb.append(type.toString() + ", ");
		sb.append(questionText.toString() + ", ");
		sb.append(literal.toString());
		sb.append(")");
		
		return sb.toString();
	}	
}
