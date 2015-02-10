package cons.ql.ast.statement;

import cons.ql.ast.Statement;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

public class Question<T extends QLType<T>> extends Statement {
	protected QLIdent identifier;
	protected T type;
	protected QLString questionText;
	
	public Question(QLIdent identifier, T type, QLString questionText) {
		this.identifier = identifier;
		this.type = type;
		this.questionText = questionText;
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	
	public T getType() {
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
