package cons.ql.ast.statement;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.visitor.Visitor;


public class ComputedQuestion extends Question {
	private final Expression expression;
	
	public ComputedQuestion(Identifier identifier, QLType type, StringLiteral text, Expression expression) {
		super(identifier, type, text);		
		this.expression = expression;		
		
//		TypeRegister.getInstance().store(this.getIdentifier(), this.getType());
	}

	public Expression getExpression() {
		return this.expression;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ComputedQuestion(");
		
		sb.append(getIdentifier().toString() + ", ");
		sb.append(getType().toString() + ", ");
		sb.append(getText().toString() + ", ");
		sb.append(getExpression().toString());
		sb.append(")");
		
		return sb.toString();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}