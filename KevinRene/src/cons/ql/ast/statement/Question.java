package cons.ql.ast.statement;

import java.util.Arrays;

import cons.ql.ast.Statement;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

@SuppressWarnings("rawtypes")
public class Question extends Statement {	
	protected final int IDENTIFIER = 0;
	protected final int TYPE = 1;
	protected final int QUESTIONTEXT = 2;
	
	public Question(QLIdent identifier, QLType type, QLString questionText) {
		this.members.addAll(Arrays.asList(identifier, type, questionText));
	}
	
	public QLIdent getIdent() {
		return (QLIdent) this.members.get(IDENTIFIER);
	}
	
	public QLType  getType() {
		return (QLType) this.members.get(TYPE);
	}
	
	public QLString getText() {
		return (QLString) this.members.get(QUESTIONTEXT);
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
}
