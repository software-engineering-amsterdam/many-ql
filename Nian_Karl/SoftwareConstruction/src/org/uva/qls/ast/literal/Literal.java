package org.uva.qls.ast.literal;

import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.qls.ast.QLSNode;
import org.uva.qls.ast.type.Type;
import org.uva.qls.visitor.LiteralVisitable;
import org.uva.utility.CodePosition;

public abstract class Literal implements QLSNode, LiteralVisitable {

	private CodePosition position;
	
	public Literal(CodePosition position) {
		this.position = position;
	}
	 
	public abstract Value getValue();
	
	public Value getValue(Evaluator e){
		throw new UnsupportedOperationException("Not supported for this Literal. Use normal getValue().");
	}
	
	public abstract Type getType();
	
	public Type getType(TypeChecker t){
		throw new UnsupportedOperationException("Not supported for this Literal. Use normal getType().");
	}
	
}
