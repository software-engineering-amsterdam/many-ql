package org.uva.ql.ast.questionnaire;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.visitor.Visitor;

public class Form implements Node{
	
	private Block block;
	private Identifier identifier;
	
	public Form(Identifier identifier, Block block) {
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
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
