package cons.ql.ast.statement;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

@SuppressWarnings("rawtypes")
public class ComputedQuestion extends Question {
	private QLType literal;
	
	@SuppressWarnings("unchecked")
	public ComputedQuestion(QLIdent identifier, QLType type, QLString text, QLType literal) {
		super(identifier, type, text);		
		this.literal = literal;		
		type.setValue(literal);
	}

	public QLType getExpression() {
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