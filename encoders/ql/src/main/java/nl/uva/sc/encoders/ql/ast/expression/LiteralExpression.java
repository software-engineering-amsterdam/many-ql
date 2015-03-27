package nl.uva.sc.encoders.ql.ast.expression;

import java.util.Set;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.literal.Literal;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.TypeMap;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class LiteralExpression extends Expression {

	private final Literal literal;

	public LiteralExpression(TextLocation textLocation, Literal literal) {
		super(textLocation);
		this.literal = literal;
	}

	public Literal getLiteral() {
		return literal;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void collectQuestionNames(Set<String> relatedQuestionNames) {
		// Do nothing, because there are no related questions to literals.
	}

	@Override
	public DataType getType(TypeMap typeMap) {
		return literal.getType();
	}

}
