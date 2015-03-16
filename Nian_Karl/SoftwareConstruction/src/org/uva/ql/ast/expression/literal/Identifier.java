package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class Identifier extends Literal {

	private final String name;

	public Identifier(String name, CodePosition pos) {
		super(pos);
		this.name = name;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Value getValue(Evaluator evaluator) {
		return evaluator.getValue(name);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return typeChecker.getType(name);
	}

	@Override
	public <T extends Value> T getValue() {
		throw new UnsupportedOperationException(
				"Can't return value of identifier, use the getValue(evaluator) to get the value.");
	}

}
