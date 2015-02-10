package cons.ql.ast.statement;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLString;

public class Question<T extends QLType<T>> extends Statement {
	private QLIdent identifier;
	private T type;
	private QLString content;
	
	public Question(QLIdent identifier, T type, QLString content) {
		this.identifier = identifier;
		this.type = type;
		this.content = content;
	}

	public String show() {
		return "Question";
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	
	public T getType() {
		return this.type;
	}
	
	public QLString getText() {
		return content;
	}
}
