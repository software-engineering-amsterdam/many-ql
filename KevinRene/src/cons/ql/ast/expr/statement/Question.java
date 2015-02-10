package cons.ql.ast.expr.statement;

import cons.ql.ast.expr.QLIdent;
import cons.ql.ast.expr.QLString;
import cons.ql.ast.expr.QLType;

public class Question extends Statement {
	
	private QLIdent identifier;
	private QLType type;
	private QLString text;
	
	public Question(QLIdent identifier, QLType type, QLString text) {
		this.identifier = identifier;
		this.type = type;
		this.text = text;
	}

	@Override
	public String show() {
		return "Question";
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	public QLType getType() {
		return this.type;
	}
	public QLString getText() {
		return this.text;
	}
}
