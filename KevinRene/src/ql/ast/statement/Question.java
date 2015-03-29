package ql.ast.statement;

import ql.ast.QLType;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.visitor.StatementVisitor;

public class Question extends Statement {
	
	private final Identifier identifier;
	private final QLType type;
	private final StringLiteral questionText;
	
	public Question(Identifier identifier, QLType type, StringLiteral questionText) {
		this.identifier = identifier;
		this.type = type;
		this.questionText = questionText;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public QLType getType() {
		return this.type;
	}
	
	public StringLiteral getText() {
		return this.questionText;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Question(");
		
		sb.append(getIdentifier().toString() + ", ");
		sb.append(getType().toString() + ", ");
		sb.append(getText().toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}