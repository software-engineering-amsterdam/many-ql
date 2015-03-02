package org.uva.ql.ast.questionnaire;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.visitor.Visitor;

public class Form implements Node{
	
	private Block block;
	private Identifier identifier;
	private final CodePosition position;
	public Form(Identifier identifier, Block block, CodePosition pos) {
		this.position = pos;
		this.identifier = identifier;
		this.block = block;
	}

	public CodePosition getPosition() {
		return position;
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
