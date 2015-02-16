package cons.ql.ast.statement;

import cons.Register;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;
import cons.ql.ast.visitor.Visitor;

@SuppressWarnings("rawtypes")
public class ComputedQuestion extends Question {
	private final Expression expression;
	
	public ComputedQuestion(QLIdent identifier, QLType type, QLString text, Expression expression) {
		super(identifier, type, text);		
		this.expression = expression;		
		
		Register.getInstance().registerBinding(getIdent(), this);
	}

	public Expression getExpression() {
		return this.expression;
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
	
	@Override 
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}