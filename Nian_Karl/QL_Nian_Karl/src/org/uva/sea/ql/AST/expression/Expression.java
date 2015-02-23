package org.uva.sea.ql.AST.expression;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.visitor.Visitor;


public abstract class Expression extends Node{	
	
	@Override
	public abstract void accept(Visitor visitor);
}