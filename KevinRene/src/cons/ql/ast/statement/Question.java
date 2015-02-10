package cons.ql.ast.statement;

import cons.ql.ast.Statement;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

@SuppressWarnings("rawtypes")
public class Question extends Statement {
	protected QLIdent identifier;
	protected QLType type;
	protected QLString questionText;
	
	public Question(QLIdent identifier, QLType type, QLString questionText) {
		this.identifier = identifier;
		this.type = type;
		this.questionText = questionText;
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	
	public QLType  getType() {
		return this.type;
	}
	
	public QLString getText() {
		return questionText;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Question(");
		
		sb.append(identifier.toString() + ", ");
		sb.append(type.toString() + ", ");
		sb.append(questionText.toString());
		sb.append(")");
		
		return sb.toString();
	}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
