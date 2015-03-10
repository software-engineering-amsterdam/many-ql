package org.uva.qls.ast.literal;

import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.qls.ast.type.Type;
import org.uva.qls.visitor.LiteralVisitor;
import org.uva.utility.CodePosition;

public class Identifier extends Literal {

	private final String name;
	
	public Identifier(String name, CodePosition position) {
		super(position);
		this.name = name;
	}

	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}
 
	@Override
	public Value getValue(Evaluator e) {
		return e.getValue(name);
	}

	@Override
	public Type getType(TypeChecker t) {
		return t.getType(name);
	}

	@Override
	public Value getValue() {
		throw new UnsupportedOperationException("Use getValue with the Evaluator.");
	}

	@Override
	public Type getType() {
		throw new UnsupportedOperationException("Use getValue with the Evaluator.");
	}

}
