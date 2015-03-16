package org.uva.ql.ast.questionnaire;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.visitor.QuestionnaireVisitor;

public class Form extends BaseNode {

	private Block block;
	private Identifier identifier;

	public Form(Identifier identifier, Block block, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
		this.block = block;
	}

	public Block getBlock() {
		return block;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public <T> T accept(QuestionnaireVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
