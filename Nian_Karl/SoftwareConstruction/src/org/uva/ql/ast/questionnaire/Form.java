package org.uva.ql.ast.questionnaire;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.visitor.QuestionnaireVisitable;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.utility.CodePosition;

public class Form extends BaseNode implements QuestionnaireVisitable{
	
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

	@Override
	public <T> T accept(QuestionnaireVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
