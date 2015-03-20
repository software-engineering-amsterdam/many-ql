package nl.uva.sc.encoders.ql.ast.expression.literal;

import java.util.Set;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.visitor.ExpressionVisitor;

public class StringLiteral extends Expression {

	private final String value;

	public StringLiteral(TextLocation textLocation, String value) {
		super(textLocation);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public void collectQuestionNames(Set<String> relatedQuestionNames) {
		// Do nothing, because there are no related questions to literals.
	}
}
