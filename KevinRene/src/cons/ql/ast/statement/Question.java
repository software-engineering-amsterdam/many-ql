package cons.ql.ast.statement;

import cons.Register;
import cons.ql.ast.Statement;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLIdent;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;

@SuppressWarnings("rawtypes")
public class Question extends Statement {	
	private final QLIdent identifier;
	private final QLType type;
	private final QLString questionText;
	
	public Question(QLIdent identifier, QLType type, QLString questionText) {
		this.identifier = identifier;
		this.type = type;
		this.questionText = questionText;
		
		Register.getInstance().registerBinding(this.identifier, this);
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	
	public QLType getType() {
		return this.type;
	}
	
	public QLString getText() {
		return this.questionText;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Question(");
		
		sb.append(getIdent().toString() + ", ");
		sb.append(getType().toString() + ", ");
		sb.append(getText().toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
