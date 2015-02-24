package org.uva.ql.ast.questionnaire;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.statement.BlockStatement;
import org.uva.ql.ast.visitor.Visitor;

public class Form implements Node{
	private BlockStatement block;
	private String identifier;
	
	public Form(BlockStatement block, String identifier) {
		this.block = block;
		this.identifier = identifier;
	}

	public BlockStatement getBlock() {
		return block;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
