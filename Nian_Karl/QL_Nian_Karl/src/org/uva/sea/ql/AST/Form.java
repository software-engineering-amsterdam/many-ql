package org.uva.sea.ql.AST;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.statement.BlockStatement;
import org.uva.sea.ql.AST.statement.Statement;
import org.uva.sea.ql.AST.visitor.Visitor;

public class Form extends Node{
	private BlockStatement block;

	public Form(BlockStatement block) {
		this.block = block;
	}

	public BlockStatement getBlock() {
		return block;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
